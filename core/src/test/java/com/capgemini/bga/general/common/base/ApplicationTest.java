package com.capgemini.bga.general.common.base;

import com.capgemini.bga.general.common.base.test.ApplicationComponentTest;
import com.capgemini.bga.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.module.basic.common.api.to.AbstractEto;
import com.devonfw.module.beanmapping.common.api.BeanMapper;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

/**
 * This test verifies that {@link com.capgemini.bga.SpringBootApp} is able to startup.
 */
public class ApplicationTest extends ApplicationComponentTest {

    @Inject
    private BeanMapper beanMapper;

    /**
     * Test that {@link it.pkg.SpringBootApp} is able to startup.
     */
    @Test
    public void testContextLoads() {

        // given
        Long id = Long.valueOf(4711);
        MyEntity entity = new MyEntity();
        entity.setId(id);
        // when
        MyEto eto = this.beanMapper.map(entity, MyEto.class);
        // then
        assertThat(eto.getId()).isEqualTo(id);
        assertThat(eto.getModificationCounter()).isEqualTo(0);
        // and when
        entity.setModificationCounter(5);
        // then
        assertThat(eto.getModificationCounter()).isEqualTo(5);
    }

    /**
     * Dummy entity for testing.
     */
    public static class MyEntity extends ApplicationPersistenceEntity {
        private static final long serialVersionUID = 1L;
    }

    /**
     * Dummy ETO for testing.
     */
    public static class MyEto extends AbstractEto {
        private static final long serialVersionUID = 1L;
    }
}