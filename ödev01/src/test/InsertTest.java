package test;

import entity.Publisher;
import entity.Reader;
import entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class InsertTest {

    private EntityManagerFactory factory;
    private EntityManager em;

    @BeforeEach
    public void init() {

        factory = Persistence.createEntityManagerFactory("Hibernate");
        em = factory.createEntityManager();
    }

    @AfterEach
    public void tearDown() {

        em.close();
        factory.close();
    }

    private boolean persistInATransaction(Object obj) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.persist(obj);
            tx.commit();
        } catch (Exception e) {
            System.out.println("FAILED TRANSACTION: " + e.toString());
            tx.rollback();
            return false;
        }

        return true;
    }


    @Test
    public void insertBook() {

        Book book =new Book();
        boolean persisted = persistInATransaction(book);
        assertTrue(persisted);

    }
    @Test
    public void insertReader() {

        Reader reader =new Reader();
        boolean persisted = persistInATransaction(reader);
        assertTrue(persisted);

    }

    @Test
    public void insertPublisher() {

        Publisher publisher =new Publisher();
        boolean persisted = persistInATransaction(publisher);
        assertTrue(persisted);

    }


}
