package com.capgemini.bga.boardgamesapp.logic.api.usecase;

import com.capgemini.bga.boardgamesapp.logic.api.Boardgamesapp;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameCostTo;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;

/**
 * Interface of UcManageGame to centralize documentation and signatures of methods.
 */
public interface UcManageGame {

    /**
     * Deletes a game from the database by its id 'gameId'.
     *
     * @param gameId Id of the game to delete
     * @return boolean <code>true</code> if the game can be deleted, <code>false</code> otherwise
     */
    boolean deleteGame(long gameId);

    /**
     * Saves a game and store it in the database.
     *
     * @param game the {@link GameEto} to create.
     * @return the new {@link GameEto} that has been saved with ID and version.
     */
    GameEto saveGame(GameEto game);

    /**
     * Modifies a game in the database.
     *
     * @param id ID of the {@link GameEto} to be modified
     * @param game game the {@link GameEto} to be modified
     * @return the recently modified {@link GameEto}
     */
    GameEto modifyGame(long id, GameCostTo game);

    /**
     * Changes a game in the database.
     *
     * @param id ID of the {@link GameEto} to be modified
     * @param game game the {@link GameEto} to be modified
     * @return the recently modified {@link GameEto}
     */
    GameEto changeGame(long id, GameEto game);

}
