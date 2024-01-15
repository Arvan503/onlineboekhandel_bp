package factory;

import entity.Book;

import java.math.BigDecimal;

public class ConcreteBookFactory implements BookFactory {
    @Override
    public Book createBook(String title, String author, String genre, String description, BigDecimal price, int stockQuantity, String publicationDate, String isbnNumber, int copy) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setDescription(description);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        book.setPublicationDate(publicationDate);
        book.setIsbnNumber(isbnNumber);
        book.setCopy(copy);
        return book;
    }
}
