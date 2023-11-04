package hello.toby.user.dao.daoV4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker {

    @Override
    public Connection makeConnection() throws SQLException {
        //N 사의 독자적인 방법으로 Connection을 생성하는 코드
        return DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/toby", "sa", "");
    }
}
