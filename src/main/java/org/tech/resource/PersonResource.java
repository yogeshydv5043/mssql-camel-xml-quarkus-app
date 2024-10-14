package org.tech.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.tech.entity.PersonModel;
import org.tech.service.PersonService;

import java.util.List;

@Path("/person")
public class PersonResource {

    @Inject
    private PersonService personService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPerson(){
        List<PersonModel> personModelList=personService.getAllPerson();
        return Response.ok(personModelList).build();
    }




    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePerson (@PathParam("id") Long id){
        String result=personService.deletePerson(id);
        return Response.ok(result).build();
    }
}
