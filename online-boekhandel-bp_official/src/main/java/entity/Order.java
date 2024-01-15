package entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private ShoppingCart cart;

    private Timestamp orderDate;
    private String status;

    // Getters and setters
    public Long Id() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(User user) {
        this.userId = user;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

}