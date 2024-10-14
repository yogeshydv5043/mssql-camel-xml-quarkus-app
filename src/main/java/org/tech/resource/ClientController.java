package org.tech.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.tech.entity.Client;
import org.tech.service.DataSendService;

import java.io.IOException;

@Path("/client")
public class ClientController {


    @Inject
    private DataSendService ciService;


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleForm(@MultipartForm Client clientData) throws IOException {
        return ciService.validateAndSend(clientData);
    }

}
