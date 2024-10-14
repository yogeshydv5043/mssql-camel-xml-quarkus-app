package org.tech.routes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.tech.repository.PersonRepository;
import org.tech.service.PersonService;
import org.tech.xmlModel.Person;

@ApplicationScoped
public class PersonRoute extends RouteBuilder {

    @Inject
    private PersonRepository personRepository;

    @Inject
    private PersonService personService;

    @Override
    public void configure() throws Exception {

        JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
        jaxbDataFormat.setContextPath("org.tech.xmlModel");

        from("direct:personSave")
                .unmarshal(jaxbDataFormat)
                .process(exchange -> {
                    Person person = exchange.getIn().getBody(Person.class);
                    exchange.getIn().setBody(person);
                })
              //  .bean(PersonService.class,"addPerson")
                .log("Sending person data ... ")
                .to("bean:personService?method=addPerson");

    }

}
