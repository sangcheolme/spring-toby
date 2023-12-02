package hello.toby.user.dao;

import hello.toby.user.dao.daoV5.ConnectionMaker;
import hello.toby.user.dao.daoV5.DConnectionMaker;
import hello.toby.user.dao.daoV6.UserDaoV6;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DaoFactory {

    @Bean
    public UserDao userDao() {
        //return new UserDaoV5(connectionMaker());
        return new UserDaoV6(dataSource());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/toby");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
}
