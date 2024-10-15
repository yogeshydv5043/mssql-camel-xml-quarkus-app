package org.tech.xmlModel.xml;

import jakarta.xml.bind.annotation.XmlRegistry;
import org.tech.xmlModel.Person;


@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public AIDXFlightLeg createAIDXFlightLeg() {
        return new AIDXFlightLeg();
    }
}
