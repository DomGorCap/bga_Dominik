package com.capgemini.bga.boardgamesapp.logic.impl.usecase;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GamePlayEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlayEto;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManageGamePlay;
import com.capgemini.bga.boardgamesapp.logic.base.usecase.AbstractGamePlayUc;
import com.capgemini.bga.general.common.api.security.ApplicationAccessControlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import java.util.Objects;

/**
 * Use case implementation for modifying and deleting GamePlays
 */
@Named
@Validated
@Transactional
public class UcManageGamePlayImpl extends AbstractGamePlayUc implements UcManageGamePlay {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UcManageGamePlayImpl.class);

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_GAMEPLAY)
    public boolean deleteGamePlay(long gamePlayId) {

        GamePlayEntity gamePlay = getGamePlayRepository().find(gamePlayId);
        getGamePlayRepository().delete(gamePlay);
        LOG.debug("The gamePlay with id '{}' has been deleted.", gamePlayId);
        return true;
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_GAMEPLAY)
    public GamePlayEto saveGamePlay(GamePlayEto gamePlay) {

        Objects.requireNonNull(gamePlay, "gamePlay");

        GamePlayEntity gamePlayEntity = getBeanMapper().map(gamePlay, GamePlayEntity.class);

        // initialize, validate gamePlayEntity here if necessary
        GamePlayEntity resultEntity = getGamePlayRepository().save(gamePlayEntity);
        LOG.debug("GamePlay with id '{}' has been created.", resultEntity.getId());
        return getBeanMapper().map(resultEntity, GamePlayEto.class);
    }
}
