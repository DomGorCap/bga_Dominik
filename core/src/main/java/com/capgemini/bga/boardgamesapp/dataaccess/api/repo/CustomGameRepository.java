package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import org.springframework.data.domain.Page;

/**
 * Repository for using queries for {@link GameEntity}
 */
public interface CustomGameRepository {

    /**
     * @param name name of the {@link GameEntity}s to find.
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> typedQuery_i(String name);

    /**
     * @param name name of the {@link GameEntity}s to find.
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> namedQuery_i(String name);

    /**
     * @param name name of the {@link GameEntity}s to find.
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> nativeQuery_i(String name);

    /**
     * @param name name of the {@link GameEntity}s to find.
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> criteriaApiQuery_i(String name);

    /**
     * @param name name of the {@link GameEntity}s to find.
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    Page<GameEntity> springDataQuery_i(String name);

}
