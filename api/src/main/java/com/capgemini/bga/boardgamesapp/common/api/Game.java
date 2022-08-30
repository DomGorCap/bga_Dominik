package com.capgemini.bga.boardgamesapp.common.api;

import com.capgemini.bga.general.common.api.ApplicationEntity;

import java.math.BigDecimal;

public interface Game extends ApplicationEntity {

    /**
     * @return name
     */

    public String getName();

    /**
     * @param name setter for name attribute
     */

    public void setName(String name);

    /**
     * @return cost
     */

    public BigDecimal getCost();

    /**
     * @param cost setter for cost attribute
     */

    public void setCost(BigDecimal cost);

    /**
     * @return complexity
     */

    public BigDecimal getComplexity();

    /**
     * @param complexity setter for complexity attribute
     */

    public void setComplexity(BigDecimal complexity);

    /**
     * @return extension
     */

    public boolean isExtension();

    /**
     * @param extension setter for extension attribute
     */

    public void setExtension(boolean extension);

}
