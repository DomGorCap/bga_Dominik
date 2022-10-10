package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.dataaccess.api.GamePlayEntity;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import org.springframework.data.domain.Page;

/**
 * Repository for using queries for {@link GamePlayEntity}
 */
public interface CustomGamePlayRepository extends DefaultRepository<GamePlayEntity> {

    /**
     * @return the {@link Page} of the {@link GamePlayEntity} objects that matched the query.
     */
    default Page<GamePlayEntity> executeQuery() {
        return null;
    }

}
