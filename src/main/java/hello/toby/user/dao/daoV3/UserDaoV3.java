package hello.toby.user.dao.daoV3;

import hello.toby.user.dao.UserDao;
import hello.toby.user.domain.User;

import java.sql.*;

/**
 * 상속을 통한 확장
 */
public abstract class UserDaoV3 implements UserDao {

    @Override
    public void add(User user) throws SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values (?,?,?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    @Override
    public User get(String id) throws SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public abstract Connection getConnection() throws SQLException;
}
