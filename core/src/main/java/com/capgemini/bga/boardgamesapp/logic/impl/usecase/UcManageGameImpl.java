package com.capgemini.bga.boardgamesapp.logic.impl.usecase;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameCostTo;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManageGame;
import com.capgemini.bga.boardgamesapp.logic.base.usecase.AbstractGameUc;
import com.capgemini.bga.general.common.api.security.ApplicationAccessControlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;

/**
 * Use case implementation for modifying and deleting Games
 */
@Named
@Validated
@Transactional
public class UcManageGameImpl extends AbstractGameUc implements UcManageGame {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UcManageGameImpl.class);

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_GAME)
    public boolean deleteGame(long gameId) {

        GameEntity game = getGameRepository().find(gameId);
        getGameRepository().delete(game);
        LOG.debug("The game with id '{}' has been deleted.", gameId);
        return true;
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_GAME)
    public GameEto saveGame(GameEto game) {

        Objects.requireNonNull(game, "game");

        GameEntity gameEntity = getBeanMapper().map(game, GameEntity.class);

        // initialize, validate gameEntity here if necessary
        GameEntity resultEntity = getGameRepository().save(gameEntity);
        LOG.debug("Game with id '{}' has been created.", resultEntity.getId());
        return getBeanMapper().map(resultEntity, GameEto.class);
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_GAME)
    public GameEto modifyGame(long id, GameCostTo game) {

        Objects.requireNonNull(game.getCost(), "cost");

        Optional<GameEntity> foundEntity = getGameRepository().findById(id);
        if (foundEntity.isPresent()) {
            GameEntity gameEntity = foundEntity.get();
            gameEntity.setCost(game.getCost());
            return getBeanMapper().map(gameEntity, GameEto.class);
        }
        else
            return null;
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_GAME)
    public GameEto changeGame(long id, GameEto game) {
        Objects.requireNonNull(game, "game");

        Optional<GameEntity> foundEntity = getGameRepository().findById(id);
        if (foundEntity.isPresent()) {
            GameEntity gameEntity = foundEntity.get();
            GameEntity gameToSave = getGameMapper().toEntity(game);

            try {
                copyDiff(gameEntity, gameToSave);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return getGameMapper().toEto(gameEntity);
        }
        else
            return null;
    }

    private static <T> void copyDiff(T destination, T source) throws IllegalAccessException, NoSuchFieldException {
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(source);

            if (!java.lang.reflect.Modifier.isStatic(field.getModifiers()))
            {

                Field destField = destination.getClass().getDeclaredField(name);
                destField.setAccessible(true);

                destField.set(destination, value);
            }
        }
    }
}
