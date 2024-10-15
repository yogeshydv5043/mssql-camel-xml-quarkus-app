package org.tech.xmlModel.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Departure {
    @XmlElement(name = "Airport")
    private Airport airport;

    @XmlElement(name = "ScheduledDateTime")
    private String scheduledDateTime;

}