package ru.aleons.longDistanceDelivery;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.aleons.longDistanceDelivery.dao.StatementDAO;
import ru.aleons.longDistanceDelivery.dao.UsersDAO;
import ru.aleons.longDistanceDelivery.impl.StatementDAOImpl;
import ru.aleons.longDistanceDelivery.impl.UsersDAOImpl;
import ru.aleons.longDistanceDelivery.model.Contractor;
import ru.aleons.longDistanceDelivery.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StatementDAOTest {

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
        StatementDAO statementDAO = new StatementDAOImpl(em);
        UsersDAO usersDAO = new UsersDAOImpl(em);
        User user = new Contractor("tester","qwerty77","222",2.1);
        usersDAO.add(user);
        assertThat(user,equalTo(em.find(User.class,"tester")));


    }

}
