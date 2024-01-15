package service;

import configuration.JPAConfiguration;
import entity.Book;
import entity.User;
import repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository repository;

    public UserService() {
        this.repository = new UserRepository(JPAConfiguration.getEntityManager());
    }


    public User createUser(User user) {
        return repository.createUser(user);
    }

    public List<User> getallusernamesandpasswords() {
        return repository.getallusernamesandpasswords();
    }

}
