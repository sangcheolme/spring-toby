package hello.toby;

import hello.toby.user.dao.DaoFactory;
import hello.toby.user.dao.daoV6.UserDaoV6;
import hello.toby.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Spring 테스트 컨텍스트 적용
 */
@ContextConfiguration(classes = DaoFactory.class)
@SpringBootTest
public class UserDaoTestV3 {

    @Autowired
    private UserDaoV6 userDao;

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        user1 = new User("gyumee", "박성철", "springno1");
        user2 = new User("leegw700", "이길원", "springno2");
        user3 = new User("bumjin", "박범진", "springno3");
    }

    @Test
    void addAndGet() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        userDao.add(user1);
        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        User findUser1 = userDao.get(user1.getId());
        assertThat(user1.getName()).isEqualTo(findUser1.getName());
        assertThat(user1.getPassword()).isEqualTo(findUser1.getPassword());

        User findUser2 = userDao.get(user2.getId());
        assertThat(user2.getName()).isEqualTo(findUser2.getName());
        assertThat(user2.getPassword()).isEqualTo(findUser2.getPassword());
    }

    @Test
    void count() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        userDao.add(user1);
        assertThat(userDao.getCount()).isEqualTo(1);

        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        userDao.add(user3);
        assertThat(userDao.getCount()).isEqualTo(3);
    }

    @Test
    void getUserFailure() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        assertThatThrownBy(() -> userDao.get("unknown_id"))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }
}
