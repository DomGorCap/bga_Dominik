package com.capgemini.bga.boardgamesapp.logic.base.usecase;

import com.capgemini.bga.boardgamesapp.dataaccess.api.repo.PlayerRepository;
import com.capgemini.bga.general.logic.base.AbstractUc;

import javax.inject.Inject;

/**
 * Abstract use case for Players, which provides access to the commonly necessary data access objects.
 */
public abstract class AbstractPlayerUc extends AbstractUc {

    /**
     * @see #getPlayerRepository()
     */
    @Inject
    private PlayerRepository playerRepository;

    /**
     * @return the {@link PlayerRepository} instance.
     */
    public PlayerRepository getPlayerRepository() {

        return this.playerRepository;
    }

}
