package hello.toby.user.dao;

import hello.toby.user.domain.User;

import java.sql.SQLException;

public interface UserDao {

    void add(User user) throws SQLException;

    User get(String id) throws SQLException;
}
