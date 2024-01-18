package hello.toby.user.dao.daoV4;

import hello.toby.user.dao.UserDao;
import hello.toby.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 커넥션을 만드는 클래스(SimpleConnectionMaker) 분리
 */
public class UserDaoV4 implements UserDao {

    private final SimpleConnectionMaker simpleConnectionMaker;

    public UserDaoV4() {
        this.simpleConnectionMaker = new SimpleConnectionMaker();
    }

    @Override
    public void add(User user) throws SQLException {
        Connection c = simpleConnectionMaker.makeNewConnection();

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
        Connection c = simpleConnectionMaker.makeNewConnection();

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
}
