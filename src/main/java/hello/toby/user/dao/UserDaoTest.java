package hello.toby.user.dao;

import hello.toby.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {

    private UserDao userDao;

    public UserDaoTest(UserDao userDao) {
        this.userDao = userDao;
    }

    public void runTest(UserDao userDao) throws SQLException {
        User user = new User();
        user.setId("test_id");
        user.setName("test_name");
        user.setPassword("test_pw");

        userDao.add(user);
        System.out.println(user.getId() + " 등록 성공");

        User findUser = userDao.get(user.getId());
        System.out.println(findUser.getName());
        System.out.println(findUser.getPassword());

        System.out.println(findUser.getId() + " 조회 성공");
    }

    public static void main(String[] args) throws SQLException {
        //UserDao userDao = new UserDaoV1();
        //UserDao userDao = new UserDaoV2();
        //UserDao userDao = new NUserDao();
        //UserDao userDao = new UserDaoV4();

        UserDao userDao = new DaoFactory().userDao();

        UserDaoTest userDaoTest = new UserDaoTest(userDao);
        userDaoTest.runTest(userDao);
    }
}
