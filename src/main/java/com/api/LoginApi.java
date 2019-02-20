package com.api;

import com.services.LoginService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")


public class LoginApi {

    LoginService loginService = new LoginService();

    @GET
    @Path("/{searchText}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.WILDCARD, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDetailsByName(@PathParam("searchText") String searchText) throws Exception {

        String destinationList = loginService.getDetailsByName(searchText);
        return Response.ok(destinationList).build();
    }

}
