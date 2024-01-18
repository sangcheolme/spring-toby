package hello.toby.user.dao.test;

import hello.toby.user.dao.DaoFactory;
import hello.toby.user.dao.UserDao;
import hello.toby.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * 테스트 검증 자동화 - 눈으로 직접 확인 X
 * 테스트 에러 - 테스트 도중 예외 발생
 * 테스트 실패 - 테스트는 정상 실행 되었지만, 원하는 결과와 다를 경우
 */
public class UserDaoTestV3 {

    public static void runTest(UserDao userDao) throws SQLException {
        userDao.deleteAll();

        User user = new User();
        user.setId("test_id");
        user.setName("test_name");
        user.setPassword("test_pw");

        userDao.add(user);

        User findUser = userDao.get(user.getId());
        if (!user.getId().equals(findUser.getId())) {
            System.out.println("테스트 실패 (id)");
        } else if (!user.getName().equals(findUser.getName())) {
            System.out.println("테스트 실패 (name)");
        } else if (!user.getPassword().equals(findUser.getPassword())) {
            System.out.println("테스트 실패 (password)");
        } else {
            System.out.println(findUser.getId() + " 조회 테스트 성공");
        }
    }

    public static void main(String[] args) throws SQLException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        runTest(userDao);
    }
}
