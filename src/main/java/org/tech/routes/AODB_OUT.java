package org.tech.routes;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.tech.dto.request.MessageData;
import org.tech.dto.request.RequestToData;
import org.tech.xmlModel.xml.AIDXFlightLeg;

@ApplicationScoped
public class AODB_OUT extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("activemq:queue:aodbOut")
                .log("AODB-OUT SERVICE : ")
                .unmarshal().json(JsonLibrary.Jackson, RequestToData.class)
                .process(exchange -> {
                    RequestToData requestToData = exchange.getIn().getBody(RequestToData.class);
                    String xmlData = requestToData.getXmlData();
                    exchange.getIn().setBody(xmlData);
                })
                .to("direct:flightSave");

    }
}
