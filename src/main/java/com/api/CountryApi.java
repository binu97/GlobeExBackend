package com.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/country")
@Consumes({MediaType.APPLICATION_JSON, MediaType.WILDCARD, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON})
public class CountryApi {

    @GET
    @Path("/name/{countryName}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.WILDCARD, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCountryByName(@PathParam("countryName") String countryName) throws Exception {
        return Response.ok(countryName).build();
    }

    @GET
    @Path("/id/{countryId}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.WILDCARD, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCountryById(@PathParam("countryId") String countryId) throws Exception {
        return Response.ok(countryId).build();
    }
}
