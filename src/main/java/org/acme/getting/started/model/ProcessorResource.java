package org.acme.getting.started.model;

import org.acme.getting.started.proxy.TokenProxy;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ProcessorResource {

    @RestClient
    TokenProxy tokenProxy;
    @ConfigProperty(name = "clientId")
    String clientId;

    @ConfigProperty(name = "clientSecret")
    String clientSecret;

    @ConfigProperty(name = "redirectUrl")
    String redirectUrl;

    @ConfigProperty(name = "publicCertContent")
    String publicCertContent;

    @ConfigProperty(name = "privateKeyContent")
    String privateKeyContent;

    @ConfigProperty(name = "authLevel")
    String authLevel;

    @ConfigProperty(name = "authApiUrl")
    String authApiUrl;

    @ConfigProperty(name = "tokenApiUrl")
    String tokenApiUrl;

    @ConfigProperty(name = "personApiUrl")
    String personApiUrl;

    @ConfigProperty(name = "attributes")
    String attributes;

    @Inject
    Environment environment;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getEnv")
    public Response getEnv() {
         if (clientId == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
         }
         return Response.ok(environment).build();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/getPersonData")
    public Response getPersonData(
            @QueryParam("code") String authCode) {
        TokenResponse tokenResponse = tokenProxy.getToken(authCode, redirectUrl, clientId, clientSecret);
        return Response.ok(tokenResponse).build();
    }
//
//    private Request createTokenRequest(String authCode) {
//        String cacheCtl = "no-cache";
//        String contentType = "application/x-www-form-urlencoded";
//        String method = "POST";
//
//        String strParams = "grant_type=authorization_code" +
//                "&code=" + authCode +
//                "&redirect_uri=" + redirectUrl +
//                "&client_id=" + clientId +
//                "&client_secret=" + clientSecret;
//
//    }


}
