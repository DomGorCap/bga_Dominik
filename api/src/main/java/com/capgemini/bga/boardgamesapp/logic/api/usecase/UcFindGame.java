package com.capgemini.bga.boardgamesapp.logic.api.usecase;

import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameSearchCriteriaTo;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface UcFindGame {

    /**
     * Returns a Game by its id 'id'.
     *
     * @param id The id 'id' of the Game.
     * @return The {@link GameEto} with id 'id'
     */
    GameEto findGame(long id);

    /**
     * Returns a paginated list of Games matching the search criteria.
     *
     * @param criteria the {@link GameSearchCriteriaTo}.
     * @return the {@link List} of matching {@link GameEto}s.
     */
    Page<GameEto> findGames(GameSearchCriteriaTo criteria);

    /**
     * Returns a paginated list of Games with any gameplay lasting more than specified value.
     *
     * @param duration of the gameplay where the game was played.
     * @return the {@link Page} of matching {@link GameEto}s.
     */
    Page<GameEto> getGamesWithAnyGamePlayLonger(BigDecimal duration);

}
