package hello.toby.user.dao.test;

import hello.toby.user.dao.DaoFactory;
import hello.toby.user.dao.UserDao;
import hello.toby.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * Spring 적용 테스트
 */
public class UserDaoTestV2 {

    public static void runTest(UserDao userDao) throws SQLException {
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
        ApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        runTest(userDao);
    }
}
