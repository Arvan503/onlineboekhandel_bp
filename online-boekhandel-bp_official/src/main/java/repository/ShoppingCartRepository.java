package repository;

import entity.ShoppingCart;
import jakarta.persistence.EntityManager;

public class ShoppingCartRepository {

    private EntityManager entityManager;

    public ShoppingCartRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(shoppingCart);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return shoppingCart;
    }

}
