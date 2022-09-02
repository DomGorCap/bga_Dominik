package com.capgemini.bga.general.common.base;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;
import org.springframework.stereotype.Component;

/**
 * Custom implementation of GameMapper to ensure enum mapping.
 */
@Component
public class GameMapperImpl implements GameMapper{

    public GameEntity toEntity(GameEto eto) {
        if ( eto == null ) {
            return null;
        }

        GameEntity entity = new GameEntity();

        entity.setName(eto.getName());
        entity.setExtension(eto.getExtension());
        entity.setCost(eto.getCost());
        entity.setComplexity(eto.getComplexity());
        entity.setId(eto.getId());

        return entity;
    }

    public GameEto toEto(GameEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GameEto eto = new GameEto();

        eto.setName(entity.getName());
        eto.setExtension(entity.getExtension());
        eto.setCost(entity.getCost());
        eto.setComplexity(entity.getComplexity());
        eto.setId(entity.getId());

        return eto;
    }
}
