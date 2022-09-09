package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.dataaccess.api.GamePlayEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

public class CustomGamePlayRepositoryImpl implements CustomGamePlayRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public Page<GamePlayEntity> typedQuery_iii(BigDecimal minGameCost) {
        TypedQuery<GamePlayEntity> typedQuery
                = this.em.createQuery("SELECT gp FROM GamePlayEntity gp, GameEntity g WHERE g.cost>=:cost AND gp.game=g", GamePlayEntity.class);
        typedQuery.setParameter("cost", minGameCost);
        List<GamePlayEntity> resultList = typedQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GamePlayEntity> namedQuery_iii(BigDecimal minGameCost) {
        Query namedQuery = this.em.createNamedQuery("GamePlayEntity.getGamePlaysWithMinGameCost");
        namedQuery.setParameter("cost", minGameCost);
        List<GamePlayEntity> resultList = namedQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GamePlayEntity> nativeQuery_iii(BigDecimal minGameCost) {
        Query nativeQuery
                = this.em.createNativeQuery("SELECT * FROM game_play JOIN game ON game_play.game_id=game.id WHERE game.cost>=:cost", GamePlayEntity.class);
        nativeQuery.setParameter("cost", minGameCost);
        List<GamePlayEntity> resultList = nativeQuery.getResultList();
        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }

    @Override
    public Page<GamePlayEntity> criteriaApiQuery_iii(BigDecimal minGameCost) {
        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
        CriteriaQuery<GamePlayEntity> criteriaQuery = criteriaBuilder.createQuery(GamePlayEntity.class);

        Root<GamePlayEntity> gameRoot = criteriaQuery.from(GamePlayEntity.class);
        gameRoot.join("game");

        List<GamePlayEntity> resultList = this.em.createQuery(criteriaQuery.select(gameRoot)
                .where(criteriaBuilder.greaterThanOrEqualTo(gameRoot.get("game").get("cost"), minGameCost)))
                        .getResultList();

        return new PageImpl<>(resultList, PageRequest.of(0, Integer.MAX_VALUE), resultList.size());
    }
}
