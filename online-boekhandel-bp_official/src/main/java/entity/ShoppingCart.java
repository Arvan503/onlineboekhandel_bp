package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

//import java.sql.Timestamp;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToOne(mappedBy = "cart")
    private Order order;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "cart_book", joinColumns = { @JoinColumn(name = "shoppingcart_id") }, inverseJoinColumns = {
            @JoinColumn(name = "book_id") })
    List<Book> books = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
