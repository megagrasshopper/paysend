package ru.paysend.app.domain.dto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum ResponseCode {
    @XmlEnumValue("0")
    OK,
    @XmlEnumValue("1")
    USER_EXISTS,
    @XmlEnumValue("2")
    TECH_ERROR,
    @XmlEnumValue("3")
    USER_DOES_NOT_EXISTS,
    @XmlEnumValue("4")
    WRONG_PASSWORD
}
