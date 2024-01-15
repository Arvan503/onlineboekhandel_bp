package repository;

import java.util.List;

import entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class BookRepository {

    private EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Book createBook(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return book;
    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    public Book getBookById(int id) {
        return entityManager.find(Book.class, id);
    }

    public Book updateBook(Book book) {
        try {
            entityManager.getTransaction().begin();
            book = entityManager.merge(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return book;
    }

    public Boolean deleteBook(int id) {
        Boolean result = false;
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Book book = entityManager.find(Book.class, id);
            if (book != null) {
                entityManager.remove(book);
                result = true;
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

        return result;
    }

    public List<Book> getallbookTitles() {
        String query = "select b from Book b";
        TypedQuery<Book> typedQuery = entityManager.createQuery(query, Book.class);
        List<Book> dienstList = typedQuery.getResultList();
        return dienstList;
    }
}