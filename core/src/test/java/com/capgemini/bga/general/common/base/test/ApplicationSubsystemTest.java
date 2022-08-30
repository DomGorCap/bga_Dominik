package com.capgemini.bga.general.common.base.test;

import com.capgemini.bga.SpringBootApp;
import com.devonfw.module.test.common.base.SubsystemDbTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * Abstract base class for {@link SubsystemTest}s of this application.
 */
@SpringBootTest(classes = {SpringBootApp.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class ApplicationSubsystemTest extends SubsystemDbTest {

}
