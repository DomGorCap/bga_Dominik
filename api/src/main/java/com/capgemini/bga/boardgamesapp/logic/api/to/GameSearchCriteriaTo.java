package com.capgemini.bga.boardgamesapp.logic.api.to;

import com.capgemini.bga.boardgamesapp.common.api.Extension;
import com.capgemini.bga.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

import java.math.BigDecimal;

/**
 * {@link SearchCriteriaTo} to find instances of {@link com.capgemini.bga.boardgamesapp.common.api.Game}s.
 */
public class GameSearchCriteriaTo extends AbstractSearchCriteriaTo {

    private static final long serialVersionUID = 1L;

    private String name;

    private BigDecimal cost;

    private BigDecimal complexity;

    private Extension extension;

    private StringSearchConfigTo nameOption;

    /**
     * @return name
     */

    public String getName() {

        return name;
    }

    /**
     * @param name setter for name attribute
     */

    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return cost
     */

    public BigDecimal getCost() {

        return cost;
    }

    /**
     * @param cost setter for cost attribute
     */

    public void setCost(BigDecimal cost) {

        this.cost = cost;
    }

    /**
     * @return complexity
     */

    public BigDecimal getComplexity() {

        return complexity;
    }

    /**
     * @param complexity setter for complexity attribute
     */

    public void setComplexity(BigDecimal complexity) {

        this.complexity = complexity;
    }

    /**
     * @return extension
     */

    public Extension getExtension() {

        return extension;
    }

    /**
     * @param extension setter for extension attribute
     */

    public void setExtension(Extension extension) {

        this.extension = extension;
    }

    /**
     * @return the {@link StringSearchConfigTo} used to search for {@link #getName() name}.
     */
    public StringSearchConfigTo getNameOption() {

        return this.nameOption;
    }

    /**
     * @param nameOption new value of {@link #getNameOption()}.
     */
    public void setNameOption(StringSearchConfigTo nameOption) {

        this.nameOption = nameOption;
    }

}
