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
import java.util.List;

public class CustomGameRepositoryImpl implements CustomGameRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<GameEntity> typedQuery_i(String name) {
        TypedQuery<GameEntity> typedQuery
                = this.em.createQuery("SELECT g FROM GameEntity g WHERE g.name=:name", GameEntity.class);
        typedQuery.setParameter("name", name);
        List<GameEntity> resultList = typedQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GameEntity> namedQuery_i(String name) {
        Query namedQuery = this.em.createNamedQuery("GameEntity.getGamesWithName");
        namedQuery.setParameter("name", name);
        List<GameEntity> resultList = namedQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GameEntity> nativeQuery_i(String name) {
        Query nativeQuery
                = this.em.createNativeQuery("SELECT * FROM game g WHERE g.name=:name", GameEntity.class);
        nativeQuery.setParameter("name", name);
        List<GameEntity> resultList = nativeQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GameEntity> criteriaApiQuery_i(String name) {
        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
        CriteriaQuery<GameEntity> criteriaQuery = criteriaBuilder.createQuery(GameEntity.class);
        Root<GameEntity> gameRoot = criteriaQuery.from(GameEntity.class);
        List<GameEntity> resultList = this.em.createQuery(criteriaQuery.select(gameRoot)
                        .where(criteriaBuilder.equal(gameRoot.get("name"), name)))
                .getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GameEntity> springDataQuery_i(String name) {
        return null;
    }
}
