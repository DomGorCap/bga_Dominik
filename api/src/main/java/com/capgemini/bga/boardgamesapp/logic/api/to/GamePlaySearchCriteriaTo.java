package com.capgemini.bga.boardgamesapp.logic.api.to;

import com.capgemini.bga.general.common.api.to.AbstractSearchCriteriaTo;

import java.math.BigDecimal;

/**
 * {@link SearchCriteriaTo} to find instances of {@link com.capgemini.bga.boardgamesapp.common.api.GamePlay}s.
 */
public class GamePlaySearchCriteriaTo extends AbstractSearchCriteriaTo {

    private static final long serialVersionUID = 1L;

    private Long gameId;

    private BigDecimal duration;

    /**
     * getter for gameId attribute
     *
     * @return gameId
     */

    public Long getGameId() {

        return gameId;
    }

    /**
     * @param gameId setter for gameId attribute
     */

    public void setGameId(Long gameId) {

        this.gameId = gameId;
    }

    /**
     * @return duration
     */

    public BigDecimal getDuration() {

        return duration;
    }

    /**
     * @param duration setter for duration attribute
     */

    public void setDuration(BigDecimal duration) {

        this.duration = duration;
    }

}
