package service;

import configuration.JPAConfiguration;
import entity.ShoppingCart;
import repository.ShoppingCartRepository;

import java.util.List;

public class ShoppingCartService {

    private final ShoppingCartRepository repository;

    public ShoppingCartService() {
        this.repository = new ShoppingCartRepository(JPAConfiguration.getEntityManager());
    }


    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return repository.createShoppingCart(shoppingCart);
    }
}

