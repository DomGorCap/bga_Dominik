package com.capgemini.bga.general.common.api.config;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;

@Named
@ApplicationPath("/api/services/rest")
@Path("/")
public class JaxRsConfig {

    public JaxRsConfig() {

    }

}
