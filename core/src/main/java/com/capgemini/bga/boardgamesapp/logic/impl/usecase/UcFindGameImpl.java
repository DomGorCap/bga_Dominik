package com.capgemini.bga.boardgamesapp.logic.impl.usecase;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameSearchCriteriaTo;
import com.capgemini.bga.boardgamesapp.logic.api.usecase.UcFindGame;
import com.capgemini.bga.boardgamesapp.logic.base.usecase.AbstractGameUc;
import com.capgemini.bga.general.common.api.security.ApplicationAccessControlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * Use case implementation for searching, filtering and getting Games
 */
@Named
@Validated
@Transactional
public class UcFindGameImpl extends AbstractGameUc implements UcFindGame {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UcFindGameImpl.class);

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_GAME)
    public GameEto findGame(long id) {

        LOG.debug("Get Game with id {} from database.", id);
        Optional<GameEntity> foundEntity = getGameRepository().findById(id);
        if (foundEntity.isPresent())
            return getBeanMapper().map(foundEntity.get(), GameEto.class);
        else
            return null;
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_GAMES)
    public Page<GameEto> findGames(GameSearchCriteriaTo criteria) {

        Page<GameEntity> games = getGameRepository().findByCriteria(criteria);
        return mapPaginatedEntityList(games, GameEto.class);
    }

    @Override
    @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_GAMES)
    public Page<GameEto> getGamesWithAnyGamePlayLonger(BigDecimal duration) {
        Page<GameEntity> games = getGameRepository().criteriaApiQuery_iv(duration);
        return mapPaginatedEntityList(games, GameEto.class);
    }

}
