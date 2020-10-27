package ru.paysend.app.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;
    private String password;
    private BigDecimal balance;
}