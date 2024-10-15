package org.tech.xmlModel.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Airline {
    @XmlElement(name = "IATA")
    private String iata;

    @XmlElement(name = "ICAO")
    private String icao;

    @XmlElement(name = "Name")
    private String name;


}