package hello.toby.user.dao.daoV1_2;

import hello.toby.user.dao.UserDao;
import hello.toby.user.domain.User;

import java.sql.*;

/**
 * 커넥션 메소드 추출
 */
public class UserDaoV2 implements UserDao {

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

    @Override
    public void deleteAll() throws SQLException {

    }

    @Override
    public int getCount() throws SQLException {
        return 0;
    }

    private static Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/toby", "sa", "");
        return c;
    }
}
