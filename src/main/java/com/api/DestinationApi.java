package com.api;

import com.services.DestinationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/destination")
@Consumes({MediaType.APPLICATION_JSON, MediaType.WILDCARD, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON})
public class DestinationApi {

    DestinationService destinationService = new DestinationService();

    @GET
    @Path("/name/{nameText}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.WILDCARD, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDestinationByName(@PathParam("nameText") String nameText) throws Exception {

        String destinationList = destinationService.getDestinationsByName(nameText);
        return Response.ok(destinationList).build();
    }

    @GET
    @Path("/town/{townText}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.WILDCARD, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDestinationByTown(@PathParam("townText") String townText) throws Exception {

        String destinationList = destinationService.getDestinationsByTown(townText);
        return Response.ok(destinationList).build();
    }
}
