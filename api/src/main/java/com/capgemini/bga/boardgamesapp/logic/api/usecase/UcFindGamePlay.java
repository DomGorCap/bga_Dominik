package com.capgemini.bga.boardgamesapp.logic.api.usecase;

import com.capgemini.bga.boardgamesapp.logic.api.to.GameEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlayEto;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlaySearchCriteriaTo;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface UcFindGamePlay {

    /**
     * Returns a GamePlay by its id 'id'.
     *
     * @param id The id 'id' of the GamePlay.
     * @return The {@link GamePlayEto} with id 'id'
     */
    GamePlayEto findGamePlay(long id);

    /**
     * Returns a paginated list of GamePlays matching the search criteria.
     *
     * @param criteria the {@link GamePlaySearchCriteriaTo}.
     * @return the {@link List} of matching {@link GamePlayEto}s.
     */
    Page<GamePlayEto> findGamePlays(GamePlaySearchCriteriaTo criteria);

    /**
     * Returns a paginated list of Games with matching name.
     *
     * @param name of the games to be returned.
     * @return the {@link List} of matching {@link GameEto}s.
     */
    Page<GamePlayEto> getGamePlaysWithMinGameCost(BigDecimal minGameCost);

}
