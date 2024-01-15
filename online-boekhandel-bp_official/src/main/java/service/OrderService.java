package service;

import configuration.JPAConfiguration;
import entity.Order;
import repository.OrderRepository;

import java.util.List;

public class OrderService {

    private final OrderRepository repository;

    public OrderService() {
        this.repository = new OrderRepository(JPAConfiguration.getEntityManager());
    }


    public Order createOrder(Order order) {
        return repository.createOrder(order);
    }
}

