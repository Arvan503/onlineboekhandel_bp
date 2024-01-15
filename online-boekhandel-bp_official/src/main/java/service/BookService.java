package service;

import java.util.ArrayList;
import java.util.List;

import configuration.JPAConfiguration;
import entity.Book;
import factory.BookFactory;
import factory.ConcreteBookFactory;
import repository.BookRepository;

public class BookService {

    private final BookRepository repository;
    private final BookFactory bookFactory;


    public Book createBook(Book book) {
        return repository.createBook(book);
    }

    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    public Book getBookById(int id) {
        return repository.getBookById(id);
    }

    public Book updateBook(Book book) {
        return repository.updateBook(book);
    }

    public Boolean deleteBook(int id) {
        return repository.deleteBook(id);
    }

    public List<Book> getallbookTitles() {
        return repository.getallbookTitles();
    }

    public BookService() {
        this.repository = new BookRepository(JPAConfiguration.getEntityManager());
        this.bookFactory = new ConcreteBookFactory();
    }

    public List<Book> createBooks(List<Book> books) {
        List<Book> createdBooks = new ArrayList<>();
        for (Book book : books) {
            Book createdBook = bookFactory.createBook(
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getDescription(),
                    book.getPrice(),
                    book.getStockQuantity(),
                    book.getPublicationDate(),
                    book.getIsbnNumber(),
                    book.getCopy()
            );
            repository.createBook(createdBook);
            createdBooks.add(createdBook);
        }
        return createdBooks;
    }

}
