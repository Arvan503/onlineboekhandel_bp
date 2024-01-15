package repository;

import entity.Book;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepository {

    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User createUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return user;
    }

    public List<User> getallusernamesandpasswords() {
        String query = "select u from User u";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        List<User> testList = typedQuery.getResultList();
        return testList;
    }
}

