package hello.toby.user.dao;

import hello.toby.user.dao.daoV4.ConnectionMaker;
import hello.toby.user.dao.daoV4.DConnectionMaker;
import hello.toby.user.dao.daoV4.UserDaoV5;

public class DaoFactory {

    public UserDao userDao() {
        return new UserDaoV5(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
