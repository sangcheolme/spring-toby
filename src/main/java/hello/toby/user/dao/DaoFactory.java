package hello.toby.user.dao;

import hello.toby.user.dao.daoV5.ConnectionMaker;
import hello.toby.user.dao.daoV5.DConnectionMaker;
import hello.toby.user.dao.daoV5.UserDaoV5;
import org.springframework.context.annotation.Bean;

public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDaoV5(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
