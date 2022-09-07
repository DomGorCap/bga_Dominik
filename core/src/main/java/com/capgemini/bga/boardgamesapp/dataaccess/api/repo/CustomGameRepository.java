package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import org.springframework.data.domain.Page;

/**
 * Repository for using queries for {@link GameEntity}
 */
public interface CustomGameRepository {

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> typedQuery_ii(int min, int max);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> namedQuery_ii(int min, int max);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> nativeQuery_ii(int min, int max);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> criteriaApiQuery_ii(int min, int max);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> springDataQuery_ii(int min, int max);

}
