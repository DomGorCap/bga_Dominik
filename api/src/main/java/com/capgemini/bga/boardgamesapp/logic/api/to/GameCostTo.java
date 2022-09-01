package com.capgemini.bga.boardgamesapp.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractEto;
import com.devonfw.module.basic.common.api.to.AbstractTo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Transport object of attribute cost of Game
 */
public class GameCostTo extends AbstractTo {

    private BigDecimal cost;

    /**
     * getter for cost attribute
     *
     * @return gameId
     */
    public BigDecimal getCost() {
        return this.cost;
    }

    /**
     * @param cost setter for cost attribute
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCostTo that = (GameCostTo) o;
        return Objects.equals(this.cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cost);
    }
}
