package com.api;

import com.services.DestinationService;
import com.services.SearchService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/search")
public class SearchApi {


    DestinationService destinationService = new DestinationService();
    SearchService searchService = new SearchService();

    @GET
    @Path("/{searchText}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.WILDCARD, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSearchItemsForText(@PathParam("searchText") String searchText) throws Exception {

        String destinationList = searchService.getDestinationsForSearch(searchText);
        return Response.ok(destinationList).build();
    }

}
