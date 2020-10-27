package ru.paysend.app.service;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.paysend.app.domain.WrongPasswordException;
import ru.paysend.app.domain.dao.UserDao;
import ru.paysend.app.domain.entity.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao dao;
    private final PasswordEncoder encoder;

    @Override
    public void saveUser(String login, String password) {
        dao.save(new User()
                .setLogin(login)
                .setPassword(encoder.encode(password)));
    }

    @Override
    public BigDecimal getBalance(String login, String password) throws WrongPasswordException {
        User user = dao.findUserByLogin(login);

        if (!encoder.matches(password, user.getPassword())) {
            throw new WrongPasswordException();
        }

        return user.getBalance();
    }
}