package ru.paysend.app.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "response")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse {

    @JacksonXmlProperty(localName = "result-code")
    private ResponseCode responseCode;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Extra> extra;

    public static ApiResponse ok() {
        return code(ResponseCode.OK);
    }

    public static ApiResponse balance(BigDecimal balance) {
        return ok().setBalance(balance);
    }

    public static ApiResponse code(ResponseCode code) {
        return new ApiResponse().setResponseCode(code);
    }

    private ApiResponse setBalance(BigDecimal balance) {
        extra = new ArrayList<>(1);
        extra.add(new Extra().setName("balance").setValue(balance.toPlainString()));
        return this;
    }

}
