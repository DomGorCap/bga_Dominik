package com.capgemini.bga.boardgamesapp.logic.impl.usecase;

import com.capgemini.bga.boardgamesapp.dataaccess.api.PlayerEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.PlayerEto;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcManagePlayer;
import com.capgemini.bga.boardgamesapp.logic.base.usecase.AbstractPlayerUc;
import com.capgemini.bga.general.common.api.security.ApplicationAccessControlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import java.util.Objects;

/**
 * Use case implementation for modifying and deleting Players
 */
@Named
@Validated
@Transactional
public class UcManagePlayerImpl extends AbstractPlayerUc implements UcManagePlayer {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UcManagePlayerImpl.class);

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_PLAYER)
    public boolean deletePlayer(long playerId) {

        PlayerEntity player = getPlayerRepository().find(playerId);
        getPlayerRepository().delete(player);
        LOG.debug("The player with id '{}' has been deleted.", playerId);
        return true;
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_PLAYER)
    public PlayerEto savePlayer(PlayerEto player) {

        Objects.requireNonNull(player, "player");

        PlayerEntity playerEntity = getBeanMapper().map(player, PlayerEntity.class);

        // initialize, validate playerEntity here if necessary
        PlayerEntity resultEntity = getPlayerRepository().save(playerEntity);
        LOG.debug("Player with id '{}' has been created.", resultEntity.getId());
        return getBeanMapper().map(resultEntity, PlayerEto.class);
    }
}
