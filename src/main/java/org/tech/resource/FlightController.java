package org.tech.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.tech.entity.FlightInfo;
import org.tech.service.FlightInfoService;

import java.util.List;

@Path("/flight")
public class FlightController {

    @Inject
    private FlightInfoService flightInfoService;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRecord(){
        List<FlightInfo> getAll=flightInfoService.getAllRecord();
        return Response.ok(getAll).build(); }


    @Path("/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteRecode(@PathParam("id")Long id){
        String result = flightInfoService.deleteRecord(id);
        return Response.ok(result).build();
    }
}
