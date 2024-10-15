package org.tech.xmlModel.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationalTimes {
    @XmlElement(name = "ActualOffBlockTime")
    private String actualOffBlockTime;

    @XmlElement(name = "ActualOnBlockTime")
    private String actualOnBlockTime;

}