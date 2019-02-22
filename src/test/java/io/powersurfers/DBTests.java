package io.powersurfers;

import io.powersurfers.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class DBTests {
    private final static String TEST_USER_LOGIN = "PowerSurfer_2019";
    private final static String TEST_USER_PASSWORD = "5e340ecd588d1e3fda0bf958e32ba52a";

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void createAndReadUser() {
        User user = new User();
        user.setLogin(TEST_USER_LOGIN);
        user.setPassword(TEST_USER_PASSWORD);
        user.setRegistrationDateTime(LocalDateTime.now());

        Session session = entityManager.unwrap(Session.class);

        try {
            session.save(user);
        } catch (HibernateException e) {
            fail("Entity not persisted");
            e.printStackTrace();
        }

        List<User> users = session.createQuery("from User", User.class).list();
        if (users.isEmpty()) {
            Assert.fail("List of users is empty");
            return;
        }

        user = users.get(users.size() - 1);

        assertNotNull(user.getId());
        assertEquals(TEST_USER_LOGIN, user.getLogin());
        assertEquals(TEST_USER_PASSWORD, user.getPassword());
    }
}
