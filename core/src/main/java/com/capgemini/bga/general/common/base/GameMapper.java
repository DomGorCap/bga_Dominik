package com.capgemini.bga.general.common.base;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;

/**
 * Mapper between GameEto and GameEntity.
 */
public interface GameMapper {

    /**
     * @param eto the {@link GameEto} to be mapped.
     * @return {@link GameEntity} with mapped parameters.
     */
    GameEntity toEntity(GameEto eto);

    /**
     * @param entity the {@link GameEntity} to be mapped.
     * @return {@link GameEto} with mapped parameters.
     */
    GameEto toEto(GameEntity entity);
}
