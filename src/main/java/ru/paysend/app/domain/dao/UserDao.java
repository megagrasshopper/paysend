package ru.paysend.app.domain.dao;

import ru.paysend.app.domain.entity.User;

public interface UserDao {

    void save(User user);

    User findUserByLogin(String login);

}
