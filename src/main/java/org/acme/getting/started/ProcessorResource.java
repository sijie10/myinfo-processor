package org.acme.getting.started;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/myinfo")
public class ProcessorResource {

    @ConfigProperty(name = "clientId")
    private String clientId;

    @ConfigProperty(name = "clientSecret")
    private String clientSecret;

    @ConfigProperty(name = "redirectUrl")
    private String redirectUrl;

    @ConfigProperty(name = "publicCertContent")
    private String publicCertContent;

    @ConfigProperty(name = "privateKeyContent")
    private String privateKeyContent;

    @ConfigProperty(name = "authLevel")
    private String authLevel;

    @ConfigProperty(name = "authApiUrl")
    private String authApiUrl;

    @ConfigProperty(name = "tokenApiUrl")
    private String tokenApiUrl;

    @ConfigProperty(name = "personApiUrl")
    private String personApiUrl;

    @ConfigProperty(name = "attributes")
    private String attributes;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getEnv")
    public Response getEnv() {
        // if (clientId == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        // }

    }


}
