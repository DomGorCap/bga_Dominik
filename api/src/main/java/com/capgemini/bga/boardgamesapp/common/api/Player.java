package com.capgemini.bga.boardgamesapp.common.api;

import com.capgemini.bga.general.common.api.ApplicationEntity;

public interface Player extends ApplicationEntity {

    /**
     * @return name
     */

    public String getName();

    /**
     * @param name setter for name attribute
     */

    public void setName(String name);

}
