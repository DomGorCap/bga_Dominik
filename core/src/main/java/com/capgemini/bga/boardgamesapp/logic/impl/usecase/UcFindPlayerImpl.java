package com.capgemini.bga.boardgamesapp.logic.impl.usecase;

import com.capgemini.bga.boardgamesapp.dataaccess.api.PlayerEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.PlayerEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.PlayerSearchCriteriaTo;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcFindPlayer;
import com.capgemini.bga.boardgamesapp.logic.base.usecase.AbstractPlayerUc;
import com.capgemini.bga.general.common.api.security.ApplicationAccessControlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import java.util.Optional;

/**
 * Use case implementation for searching, filtering and getting Players
 */
@Named
@Validated
@Transactional
public class UcFindPlayerImpl extends AbstractPlayerUc implements UcFindPlayer {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UcFindPlayerImpl.class);

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_PLAYER)
    public PlayerEto findPlayer(long id) {

        LOG.debug("Get Player with id {} from database.", id);
        Optional<PlayerEntity> foundEntity = getPlayerRepository().findById(id);
        if (foundEntity.isPresent())
            return getBeanMapper().map(foundEntity.get(), PlayerEto.class);
        else
            return null;
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_PLAYERS)
    public Page<PlayerEto> findPlayers(PlayerSearchCriteriaTo criteria) {

        Page<PlayerEntity> players = getPlayerRepository().findByCriteria(criteria);
        return mapPaginatedEntityList(players, PlayerEto.class);
    }

}
