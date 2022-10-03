package com.capgemini.bga.boardgamesapp.dataaccess.api.repo.impl;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.dataaccess.api.GamePlayEntity;
import com.capgemini.bga.boardgamesapp.dataaccess.api.repo.CustomGameRepository;
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
import javax.persistence.criteria.Subquery;
import java.math.BigDecimal;
import java.util.List;

public class CustomGameRepositoryImpl implements CustomGameRepository {

    @PersistenceContext
    public EntityManager em;

    @Override
    public Page<GameEntity> typedQuery_iv(BigDecimal duration) {
        TypedQuery<GameEntity> typedQuery
                = this.em.createQuery("SELECT DISTINCT g FROM GameEntity g, GamePlayEntity gp WHERE gp.duration>:duration AND gp.game=g", GameEntity.class);
        typedQuery.setParameter("duration", duration);
        List<GameEntity> resultList = typedQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GameEntity> namedQuery_iv(BigDecimal duration) {
        Query namedQuery = this.em.createNamedQuery("GameEntity.getGamesWithAnyGamePlayLonger");
        namedQuery.setParameter("duration", duration);
        List<GameEntity> resultList = namedQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GameEntity> nativeQuery_iv(BigDecimal duration) {
        Query nativeQuery
                = this.em.createNativeQuery("SELECT DISTINCT g.* FROM game g JOIN game_play gp ON g.id=gp.game_id WHERE gp.duration>:duration", GameEntity.class);
        nativeQuery.setParameter("duration", duration);
        List<GameEntity> resultList = nativeQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GameEntity> criteriaApiQuery_iv(BigDecimal duration) {
        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
        CriteriaQuery<GameEntity> criteriaQuery = criteriaBuilder.createQuery(GameEntity.class);
        Root<GameEntity> root = criteriaQuery.from(GameEntity.class);

        Subquery<List> sub = criteriaQuery.subquery(List.class);
        Root<GamePlayEntity> subRoot = sub.from(GamePlayEntity.class);

        sub.select(subRoot.get("game"));
        sub.where(criteriaBuilder.gt(subRoot.get("duration"), duration));

        List<GameEntity> resultList = this.em.createQuery(criteriaQuery.select(root)
                                .where(root.get("id").in(sub)).distinct(true))
                .getResultList();

        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }
}
