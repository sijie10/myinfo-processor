package org.acme.getting.started.model;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Environment {

    @ConfigProperty(name = "clientId")
    String clientId;

    @ConfigProperty(name = "redirectUrl")
    String redirectUrl;

    @ConfigProperty(name = "authLevel")
    String authLevel;

    @ConfigProperty(name = "authApiUrl")
    String authApiUrl;

    @ConfigProperty(name = "attributes")
    String attributes;

    String status = "OK";

    public String getClientId() {
        return clientId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getAuthLevel() {
        return authLevel;
    }

    public String getAuthApiUrl() {
        return authApiUrl;
    }

    public String getAttributes() {
        return attributes;
    }

    public String getStatus() { return status; }
}
