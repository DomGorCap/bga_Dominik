package com.capgemini.bga.boardgamesapp.dataaccess.api;

import com.capgemini.bga.boardgamesapp.common.api.Game;
import com.capgemini.bga.general.dataaccess.api.ApplicationPersistenceEntity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "game")
@NamedQuery(name = "GameEntity.getGamesWithPriceInRange", query = "SELECT g FROM GameEntity g WHERE g.cost BETWEEN :min AND :max")
public class GameEntity extends ApplicationPersistenceEntity implements Game {

    private static final long serialVersionUID = 1L;
    private String name;
    private BigDecimal cost;
    private BigDecimal complexity;
    private boolean extension;

    /**
     * @return name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name the new value.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return cost
     */
    public BigDecimal getCost() {

        return this.cost;
    }

    /**
     * @param cost the new value.
     */
    public void setCost(BigDecimal cost) {

        this.cost = cost;
    }

    /**
     * @return complexity
     */
    public BigDecimal getComplexity() {

        return this.complexity;
    }

    /**
     * @param complexity the new value.
     */
    public void setComplexity(BigDecimal complexity) {

        this.complexity = complexity;
    }

    /**
     * @return extension
     */
    public boolean isExtension() {

        return this.extension;
    }

    /**
     * @param extension the new value.
     */
    public void setExtension(boolean extension) {

        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof GameEntity)) {
            return false;
        }

        GameEntity that = (GameEntity) o;

        if (this.extension != that.extension) {
            return false;
        }
        if (!this.name.equals(that.name)) {
            return false;
        }
        if (this.cost != null ? !this.cost.equals(that.cost) : that.cost != null) {
            return false;
        }
        return this.complexity != null ? this.complexity.equals(that.complexity) : that.complexity == null;
    }

    @Override
    public int hashCode() {

        int result = this.name.hashCode();
        result = 31 * result + (this.cost != null ? this.cost.hashCode() : 0);
        result = 31 * result + (this.complexity != null ? this.complexity.hashCode() : 0);
        result = 31 * result + (this.extension ? 1 : 0);
        return result;
    }

}
