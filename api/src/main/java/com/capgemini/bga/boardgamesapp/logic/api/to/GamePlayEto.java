package com.capgemini.bga.boardgamesapp.logic.api.to;

import com.capgemini.bga.boardgamesapp.common.api.GamePlay;
import com.devonfw.module.basic.common.api.to.AbstractEto;

import java.math.BigDecimal;

/**
 * Entity transport object of GamePlay
 */
public class GamePlayEto extends AbstractEto implements GamePlay {

    private static final long serialVersionUID = 1L;

    private Long gameId;

    private BigDecimal duration;

    @Override
    public Long getGameId() {

        return gameId;
    }

    @Override
    public void setGameId(Long gameId) {

        this.gameId = gameId;
    }

    @Override
    public BigDecimal getDuration() {

        return duration;
    }

    @Override
    public void setDuration(BigDecimal duration) {

        this.duration = duration;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();

        result = prime * result + ((this.gameId == null) ? 0 : this.gameId.hashCode());
        result = prime * result + ((this.duration == null) ? 0 : this.duration.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // class check will be done by super type EntityTo!
        if (!super.equals(obj)) {
            return false;
        }
        GamePlayEto other = (GamePlayEto) obj;

        if (this.gameId == null) {
            if (other.gameId != null) {
                return false;
            }
        } else if (!this.gameId.equals(other.gameId)) {
            return false;
        }
        if (this.duration == null) {
            if (other.duration != null) {
                return false;
            }
        } else if (!this.duration.equals(other.duration)) {
            return false;
        }

        return true;
    }
}
