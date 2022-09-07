package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import org.springframework.data.domain.Page;

public class CustomGameRepositoryImpl implements CustomGameRepository {
    @Override
    public Page<GameEntity> typedQuery() {
        return null;
    }

    @Override
    public Page<GameEntity> namedQuery() {
        return null;
    }

    @Override
    public Page<GameEntity> nativeQuery() {
        return null;
    }

    @Override
    public Page<GameEntity> criteriaApiQuery() {
        return null;
    }

    @Override
    public Page<GameEntity> springDataQuery() {
        return null;
    }
}
