package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import org.springframework.data.domain.Page;

/**
 * Repository for using queries for {@link GameEntity}
 */
public interface CustomGameRepository extends DefaultRepository<GameEntity> {

    /**
     * @return the {@link Page} of the {@link GameEntity} objects that matched the query.
     */
    default Page<GameEntity> executeQuery() {
        return null;
    }

}
