package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class CustomGameRepositoryImpl implements CustomGameRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Page<GameEntity> typedQuery_ii(BigDecimal min, BigDecimal max) {
        TypedQuery<GameEntity> typedQuery
                = this.em.createQuery("SELECT g FROM GameEntity g WHERE g.cost>:min AND g.cost<:max", GameEntity.class);
        typedQuery.setParameter("min", min);
        typedQuery.setParameter("max", max);
        List<GameEntity> resultList = typedQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, resultList.size()), resultList.size());
    }

    @Override
    public Page<GameEntity> namedQuery_ii(BigDecimal min, BigDecimal max) {
        Query namedQuery = this.em.createNamedQuery("GameEntity.getGamesWithPriceInRange");
        namedQuery.setParameter("min", min);
        namedQuery.setParameter("max", max);
        List<GameEntity> resultList = namedQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, resultList.size()), resultList.size());
    }

    @Override
    public Page<GameEntity> nativeQuery_ii(BigDecimal min, BigDecimal max) {
        Query nativeQuery
                = this.em.createNativeQuery("SELECT * FROM game g WHERE g.cost>:min AND g.cost<:max", GameEntity.class);
        nativeQuery.setParameter("min", min);
        nativeQuery.setParameter("max", max);
        List<GameEntity> resultList = nativeQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, resultList.size()), resultList.size());
    }

    @Override
    public Page<GameEntity> criteriaApiQuery_ii(BigDecimal min, BigDecimal max) {
        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
        CriteriaQuery<GameEntity> criteriaQuery = criteriaBuilder.createQuery(GameEntity.class);
        Root<GameEntity> gameRoot = criteriaQuery.from(GameEntity.class);
        List<GameEntity> resultList = this.em.createQuery(criteriaQuery.select(gameRoot)
                        .where(criteriaBuilder.between(gameRoot.get("cost"), min, max)))
                .getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, resultList.size()), resultList.size());
    }
}
