package org.acme.getting.started.proxy;

import org.acme.getting.started.model.TokenResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v3")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://sandbox.api.myinfo.gov.sg/com/")
public interface TokenProxy {

    @GET
    @Path("/token")
    TokenResponse getToken(@QueryParam("code") String code,
                           @QueryParam("redirect_uri") String redirect_uri,
                           @QueryParam("client_id") String client_id,
                           @QueryParam("client_secret") String client_secret);

}
