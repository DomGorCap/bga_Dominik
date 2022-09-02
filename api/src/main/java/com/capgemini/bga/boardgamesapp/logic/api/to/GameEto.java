package com.capgemini.bga.boardgamesapp.logic.api.to;

import com.capgemini.bga.boardgamesapp.common.api.Extension;
import com.capgemini.bga.boardgamesapp.common.api.Game;
import com.devonfw.module.basic.common.api.to.AbstractEto;

import java.math.BigDecimal;

/**
 * Entity transport object of Game
 */
public class GameEto extends AbstractEto implements Game {

    private static final long serialVersionUID = 1L;

    private String name;

    private BigDecimal cost;

    private BigDecimal complexity;

    private Extension extension = Extension.TRUE;

    public Extension getExtension() {
        return this.extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    @Override
    public boolean isExtension() {
        return getExtension() == Extension.TRUE;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public void setName(String name) {

        this.name = name;
    }

    @Override
    public BigDecimal getCost() {

        return cost;
    }

    @Override
    public void setCost(BigDecimal cost) {

        this.cost = cost;
    }

    @Override
    public BigDecimal getComplexity() {

        return complexity;
    }

    @Override
    public void setComplexity(BigDecimal complexity) {

        this.complexity = complexity;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.cost == null) ? 0 : this.cost.hashCode());
        result = prime * result + ((this.complexity == null) ? 0 : this.complexity.hashCode());
        result = prime * result + ((this.extension == null) ? 0 : this.extension.hashCode());
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
        GameEto other = (GameEto) obj;
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.cost == null) {
            if (other.cost != null) {
                return false;
            }
        } else if (!this.cost.equals(other.cost)) {
            return false;
        }
        if (this.complexity == null) {
            if (other.complexity != null) {
                return false;
            }
        } else if (!this.complexity.equals(other.complexity)) {
            return false;
        }
        if (this.extension != other.extension) {
            return false;
        }
        return true;
    }
}
