package hello.toby.user.dao;

import hello.toby.user.dao.daoV4.ConnectionMaker;
import hello.toby.user.dao.daoV4.DConnectionMaker;
import hello.toby.user.dao.daoV4.UserDaoV5;

public class DaoFactory {

    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return new UserDaoV5(connectionMaker);
    }
}
