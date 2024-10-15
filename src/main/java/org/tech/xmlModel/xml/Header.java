package org.tech.xmlModel.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
    public  class Header {
        @XmlElement(name = "MessageType")
        private String messageType;

        @XmlElement(name = "MessageVersion")
        private String messageVersion;

        @XmlElement(name = "SenderID")
        private String senderID;

        @XmlElement(name = "RecipientID")
        private String recipientID;

        @XmlElement(name = "CreationDateTime")
        private String creationDateTime;

    }