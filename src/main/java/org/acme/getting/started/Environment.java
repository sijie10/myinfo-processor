package org.acme.getting.started;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Environment {

    @ConfigProperty(name = "clientId")
    private String clientId;

    @ConfigProperty(name = "redirectUrl")
    private String redirectUrl;

    @ConfigProperty(name = "authLevel")
    private String authLevel;

    @ConfigProperty(name = "authApiUrl")
    private String authApiUrl;

    @ConfigProperty(name = "attributes")
    private String attributes;

}
