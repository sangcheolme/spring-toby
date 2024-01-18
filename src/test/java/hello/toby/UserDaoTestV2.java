package hello.toby;

import hello.toby.user.dao.DaoFactory;
import hello.toby.user.dao.daoV6.UserDaoV6;
import hello.toby.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * UserDao에 deleteAll()와 getCount() 기능을 추가하여 반복 가능한 테스트 만들기
 */
public class UserDaoTestV2 {

    @Test
    void addAndGet() throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDaoV6 userDao = context.getBean("userDaoV6", UserDaoV6.class);

        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        User user = new User();
        user.setId("testId");
        user.setName("testName");
        user.setPassword("testPw");

        userDao.add(user);
        assertThat(userDao.getCount()).isEqualTo(1);

        User findUser = userDao.get(user.getId());

        assertThat(user.getName()).isEqualTo(findUser.getName());
        assertThat(user.getPassword()).isEqualTo(findUser.getPassword());
    }

    @Test
    void count() throws SQLException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDaoV6 userDao = ac.getBean("userDaoV6", UserDaoV6.class);

        User user1 = new User("gyumee", "박성철", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");
        User user3 = new User("bumjin", "박범진", "springno3");

        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        userDao.add(user1);
        assertThat(userDao.getCount()).isEqualTo(1);

        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        userDao.add(user3);
        assertThat(userDao.getCount()).isEqualTo(3);
    }
}
