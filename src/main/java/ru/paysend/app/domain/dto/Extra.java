package ru.paysend.app.domain.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
class Extra {
    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;
    @JacksonXmlText
    private String value;
}
