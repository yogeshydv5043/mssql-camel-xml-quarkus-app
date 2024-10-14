package org.tech.routes;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.tech.dto.request.MessageData;
import org.tech.dto.request.RequestToData;

@ApplicationScoped
public class DefaultBHS extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("activemq:queue:defaultBhs")
                .log(" This Is DefaultBHS : ${body}")
                .unmarshal().json(JsonLibrary.Jackson, MessageData.class)
                .process(exchange -> {
                    MessageData messageData = exchange.getIn().getBody(MessageData.class);
                    RequestToData requestToData=new RequestToData(messageData.getTo(),messageData.getXmlData());
                    exchange.getIn().setBody(requestToData);
                })
                .choice()
                // If 'from' equals 'AODB_IN', send to 'aodb_inQueue'
                .when(simple("${body.to} == 'AODB-IN'"))
                .log("Routing message to AODB_IN queue")
                .marshal().json(JsonLibrary.Jackson)
                .to("activemq:queue:aodbIn")

                // If 'from' equals 'AODB_OUT', send to 'aodb_outQueue'
                .when(simple("${body.to} == 'AODB-OUT'"))
                .log("Routing message to AODB_OUT queue")
                .marshal().json(JsonLibrary.Jackson)
                .to("activemq:queue:aodbOut")

                // Otherwise, route to the default queue
                .otherwise()
                .log("Routing message to default queue")
                .marshal().json(JsonLibrary.Jackson)
                .to("activemq:queue:defaultAodb")
                .end();


    }
}
