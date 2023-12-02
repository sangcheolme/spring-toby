package hello.toby.user.dao;

import hello.toby.user.dao.daoV5.ConnectionMaker;
import hello.toby.user.dao.daoV5.DConnectionMaker;
import hello.toby.user.dao.daoV5.UserDaoV5;

public class DaoFactory {

    public UserDao userDao() {
        return new UserDaoV5(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
