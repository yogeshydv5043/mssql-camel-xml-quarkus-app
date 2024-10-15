package org.tech.routes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.tech.repository.PersonRepository;
import org.tech.service.PersonService;
import org.tech.xmlModel.Person;
import org.tech.xmlModel.xml.AIDXFlightLeg;

@ApplicationScoped
public class FlightRoute extends RouteBuilder {

    @Inject
    private PersonRepository personRepository;

    @Inject
    private PersonService personService;

    @Override
    public void configure() throws Exception {

        JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
        jaxbDataFormat.setContextPath("org.tech.xmlModel.xml");

        from("direct:flightSave")
                .unmarshal().jaxb("org.tech.xmlModel.xml")
                //.unmarshal(jaxbDataFormat)
                .process(exchange -> {
                    AIDXFlightLeg flightLeg = exchange.getIn().getBody(AIDXFlightLeg.class);
                    exchange.getIn().setBody(flightLeg);
                })
              //  .bean(PersonService.class,"addPerson")
                .log("Sending person data ... ")
                .to("bean:flightInfoRequest?method=convertToFlightInfoRequest");

    }

}
