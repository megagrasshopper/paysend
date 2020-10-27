package ru.paysend.app.domain.dao;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.paysend.app.domain.entity.User;

@Component
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private static final String INSERT_QUEY = "INSERT INTO users (login, password) VALUES (:login,:password)";
    private static final String SELECT_QUEY = "SELECT login, password, balance FROM users WHERE login=:login";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String BALANCE = "balance";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void save(User user) {

        Map<String, Object> params = new HashMap<String, Object>() {{
            put(LOGIN, user.getLogin());
            put(PASSWORD, user.getPassword());
        }};

        jdbcTemplate.update(INSERT_QUEY, params);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByLogin(String login) {
        Map<String, Object> params = new HashMap<String, Object>() {{
            put(LOGIN, login);
        }};
        return jdbcTemplate.queryForObject(SELECT_QUEY, params, (rs, rowNum) ->
                new User()
                        .setLogin(rs.getString(LOGIN))
                        .setPassword(rs.getString(PASSWORD))
                        .setBalance(rs.getBigDecimal(BALANCE))
        );
    }
}
