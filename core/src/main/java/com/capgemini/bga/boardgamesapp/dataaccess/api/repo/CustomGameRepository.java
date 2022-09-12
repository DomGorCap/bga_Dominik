package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

/**
 * Repository for using queries for {@link GameEntity}
 */
public interface CustomGameRepository {

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> typedQuery_iv(BigDecimal duration);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> namedQuery_iv(BigDecimal duration);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> nativeQuery_iv(BigDecimal duration);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> criteriaApiQuery_iv(BigDecimal duration);

}
