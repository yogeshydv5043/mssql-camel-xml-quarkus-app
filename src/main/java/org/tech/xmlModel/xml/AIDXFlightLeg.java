package org.tech.xmlModel.xml;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@XmlRootElement(name = "AIDXFlightLeg")
@XmlAccessorType(XmlAccessType.FIELD)
public class AIDXFlightLeg {

    @XmlElement(name = "Header")
    private Header header;

    @XmlElement(name = "FlightLeg")
    private FlightLeg flightLeg;



}

