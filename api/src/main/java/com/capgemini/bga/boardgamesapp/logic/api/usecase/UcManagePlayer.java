package com.capgemini.bga.boardgamesapp.logic.api.usecase;

import com.capgemini.bga.boardgamesapp.logic.api.to.PlayerEto;

/**
 * Interface of UcManagePlayer to centralize documentation and signatures of methods.
 */
public interface UcManagePlayer {

    /**
     * Deletes a player from the database by its id 'playerId'.
     *
     * @param playerId Id of the player to delete
     * @return boolean <code>true</code> if the player can be deleted, <code>false</code> otherwise
     */
    boolean deletePlayer(long playerId);

    /**
     * Saves a player and store it in the database.
     *
     * @param player the {@link PlayerEto} to create.
     * @return the new {@link PlayerEto} that has been saved with ID and version.
     */
    PlayerEto savePlayer(PlayerEto player);

}
