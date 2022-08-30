package com.capgemini.bga.boardgamesapp.logic.api;

import com.capgemini.bga.boardgamesapp.logic.api.usecase.*;

/**
 * Interface for Boardgamesapp component.
 */
public interface Boardgamesapp
        extends UcFindGame, UcManageGame, UcFindGamePlay, UcManageGamePlay, UcFindPlayer, UcManagePlayer {

}
