package factory;

import entity.Book;

import java.math.BigDecimal;

public interface BookFactory {
    Book createBook(String title, String author, String genre, String description, BigDecimal price, int stockQuantity, String publicationDate, String isbnNumber, int copy);
}
