package ru.paysend.app.domain.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "request")
public class ApiRequest {

    @NotNull
    @JacksonXmlProperty(localName = "request-type")
    private RequestType requestType;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Extra> extra;

    @NotEmpty
    public String getLogin() {
        return getField("login");
    }

    @NotEmpty
    public String getPassword() {
        return getField("password");
    }

    private String getField(String fieldName) {
        return extra.stream().filter(e -> e.getName().equalsIgnoreCase(fieldName))
                .findAny().map(Extra::getValue).orElse("");
    }
}

