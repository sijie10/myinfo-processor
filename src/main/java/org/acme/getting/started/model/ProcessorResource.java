package org.acme.getting.started.model;

import io.vertx.core.json.Json;
import jdk.jfr.ContentType;
import org.acme.getting.started.proxy.TokenProxy;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestForm;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Path("/")
public class ProcessorResource {

    //this gets injected after the class is instantiated by Jersey
    @Context
    UriInfo uriInfo;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/getPersonData")
    public Response getPersonData(@RestForm String code) {
        System.out.println("Getting person data..");
        System.out.println(code);
//        TokenResponse tokenResponse = tokenProxy.getToken("dummyAuthCode", redirectUrl, clientId, clientSecret);
//        return Response.ok(tokenResponse).build();
        return Response.noContent().build();
    }

    @GET
    @Path("/callback")
    @Produces({MediaType.TEXT_HTML})
    public InputStream viewHome()
    {
        System.out.println(System.getProperty("user.dir"));
        File f = new File(System.getProperty("user.dir") + "\\..\\src\\main\\resources\\META-INF\\resources\\index.html");
        try {
            return new FileInputStream(f);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    @Path("/callback")
//    @GET
//    public Response callback(){
//        UriBuilder addressBuilder = uriInfo.getBaseUriBuilder();
//        addressBuilder.path("/");
//        return Response.seeOther(addressBuilder.build()).build();
//    }
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
