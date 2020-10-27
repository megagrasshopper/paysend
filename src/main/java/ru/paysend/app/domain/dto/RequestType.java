package ru.paysend.app.domain.dto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum RequestType {
    @XmlEnumValue("CREATE-AGT")
    CREATE,
    @XmlEnumValue("GET-BALANCE")
    BALANCE
}
