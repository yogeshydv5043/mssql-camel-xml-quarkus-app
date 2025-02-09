package org.tech.xmlModel;

import jakarta.xml.bind.annotation.XmlRegistry;
import org.tech.xmlModel.xml.AIDXFlightLeg;


@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Person createPerson() {
        return new Person();
    }

    public AIDXFlightLeg createAIDXFlightLeg() {
        return new AIDXFlightLeg();
    }
}
