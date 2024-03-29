package com.capgemini.bga.general.common.impl.config;

import com.devonfw.module.test.common.base.clean.TestCleaner;
import com.devonfw.module.test.common.base.clean.TestCleanerImpl;
import com.devonfw.module.test.common.base.clean.TestCleanerPlugin;
import com.devonfw.module.test.common.base.clean.TestCleanerPluginFlyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link Configuration} for Database in JUnit tests.
 */
@Configuration
public class TestDbConfig {

    /**
     * @return the {@link TestCleaner}.
     */
    @Bean
    public TestCleaner testCleaner() {

        return new TestCleanerImpl();
    }

    /**
     * @return the {@link TestCleanerPluginFlyway}.
     */
    @Bean
    public TestCleanerPlugin testCleanerPluginFlyway() {

        return new TestCleanerPluginFlyway();
    }

}
