package com.capgemini.bga.boardgamesapp.logic.api.usecase;

import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlayEto;

/**
 * Interface of UcManageGamePlay to centralize documentation and signatures of methods.
 */
public interface UcManageGamePlay {

    /**
     * Deletes a gamePlay from the database by its id 'gamePlayId'.
     *
     * @param gamePlayId Id of the gamePlay to delete
     * @return boolean <code>true</code> if the gamePlay can be deleted, <code>false</code> otherwise
     */
    boolean deleteGamePlay(long gamePlayId);

    /**
     * Saves a gamePlay and store it in the database.
     *
     * @param gamePlay the {@link GamePlayEto} to create.
     * @return the new {@link GamePlayEto} that has been saved with ID and version.
     */
    GamePlayEto saveGamePlay(GamePlayEto gamePlay);

}
