package com.mw.rest;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class RestWebService extends ResourceConfig{
    public RestWebService() {
    	packages("com.mw.rest");
        register(JacksonFeature.class);
        register(LoggingFilter.class);
    }
}
