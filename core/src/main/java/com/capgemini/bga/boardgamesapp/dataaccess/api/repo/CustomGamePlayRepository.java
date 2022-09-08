package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.dataaccess.api.GamePlayEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlayEto;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

/**
 * Repository for using queries for {@link GamePlayEntity}
 */
public interface CustomGamePlayRepository {

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GamePlayEntity> typedQuery_iii(BigDecimal minGameCost);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GamePlayEntity> namedQuery_iii(BigDecimal minGameCost);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GamePlayEntity> nativeQuery_iii(BigDecimal minGameCost);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GamePlayEntity> criteriaApiQuery_iii(BigDecimal minGameCost);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GamePlayEntity> springDataQuery_iii(BigDecimal minGameCost);

}
