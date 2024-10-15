package org.tech.xmlModel.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class FlightLeg {

    @XmlElement(name = "Airline")
    private Airline airline;

    @XmlElement(name = "FlightNumber")
    private String flightNumber;

    @XmlElement(name = "Departure")
    private Departure departure;

    @XmlElement(name = "Arrival")
    private Arrival arrival;

    @XmlElement(name = "Aircraft")
    private Aircraft aircraft;

    @XmlElement(name = "OperationalTimes")
    private OperationalTimes operationalTimes;
    
}