package com.capgemini.bga.general.common.base;

import com.devonfw.module.beanmapping.common.api.BeanMapper;

import javax.inject.Inject;

/**
 * This abstract class provides {@link #getBeanMapper() access} to the {@link BeanMapper}.
 */
public abstract class AbstractBeanMapperSupport {

    private BeanMapper beanMapper;

    private GameMapper gameMapper;

    /**
     * @return the {@link GameMapper} instance.
     */
    protected GameMapper getGameMapper() {
        return this.gameMapper;
    }

    /**
     * @param gameMapper is the {@link GameMapper} to {@link Inject}
     */
    @Inject
    public void setGameMapper(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    /**
     * @return the {@link BeanMapper} instance.
     */
    protected BeanMapper getBeanMapper() {

        return this.beanMapper;
    }

    /**
     * @param beanMapper is the {@link BeanMapper} to {@link Inject}
     */
    @Inject
    public void setBeanMapper(BeanMapper beanMapper) {

        this.beanMapper = beanMapper;
    }

}
