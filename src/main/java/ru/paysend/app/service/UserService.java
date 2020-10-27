package ru.paysend.app.service;

import java.math.BigDecimal;
import ru.paysend.app.domain.WrongPasswordException;

public interface UserService {
    void saveUser(String login, String password);

    BigDecimal getBalance(String login, String password) throws WrongPasswordException;
}
