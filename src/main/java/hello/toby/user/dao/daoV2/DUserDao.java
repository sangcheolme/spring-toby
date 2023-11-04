package hello.toby.user.dao.daoV2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserDao extends UserDaoV3 {

    @Override
    public Connection getConnection() throws SQLException {
        //D 사의 독자적인 방법으로 Connection을 생성하는 코드
        return DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/toby", "sa", "");
    }

}
