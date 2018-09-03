package ru.aleons.longDistanceDelivery;

import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.aleons.longDistanceDelivery.dao.UsersDAO;
import ru.aleons.longDistanceDelivery.impl.UsersDAOImpl;
import ru.aleons.longDistanceDelivery.model.Contractor;
import ru.aleons.longDistanceDelivery.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class UserDaoTest {


    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeMethod
    public void setup() {
        emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = emf.createEntityManager();
    }

    @AfterMethod
    public void after() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    @Test(description = "check add user")
    void checkUserAdd(){
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user = new Contractor("tester","qwerty77","222",2.1);
        usersDAO.add(user);
        assertThat(user,equalTo(em.find(User.class,"tester")));
    }

    @Test(description = "check not add user where password the null")
    void checkNotAddUserNullPassword(){
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user = null;
        try {
            user = new Contractor("tester", null,"333",2.2);
            usersDAO.add(user);
            assertThat(user, not(em.find(User.class,"tester")));
        }
        catch (IllegalArgumentException e){
            user = null;
            assertThat(user, equalTo(em.find(User.class,"tester")));
        }
    }

    @Test(description = "check hash password")
    void checkHashPassword() throws NoSuchAlgorithmException {
        String password = "qwerty77";
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(password.getBytes(),0,password.length());
        String hashPassword = new BigInteger(1,m.digest()).toString(16);
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user = new Contractor("test", password, "222",2.2);
        usersDAO.add(user);
        System.out.println(em.find(User.class,"test").getPassword());
        assertThat(hashPassword,equalTo(em.find(User.class,"test").getPassword()));
    }

    @Test(description = "check delete user")
    void checkDeleteUser(){
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user = new Contractor("tester","qwerty77","222",2.1);
        usersDAO.add(user);
        assertThat(user,equalTo(em.find(User.class,"tester")));
        usersDAO.delete(user);
        assertThat(user,not(em.find(User.class,"tester")));
    }

    @Test(description = "check update User")
    void checkUpdateUser(){
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user = new Contractor("tester","qwerty77","222",2.1);
        String oldPassword = user.getPassword();
        usersDAO.add(user);
        assertThat(user,equalTo(em.find(User.class,"tester")));
        user.setPassword("qwerty88");
        user.setTel("333");
        user.setAverageLevel(3.2);
        usersDAO.update(user.getLogin(),user);
        assertThat(oldPassword,not(em.find(User.class,"tester").getPassword()));


    }


}
