package pl.camp.it.distance.coaching.manager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.camp.it.distance.coaching.manager.database.IUserDAO;
import pl.camp.it.distance.coaching.manager.model.User;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserDAO {
    @Autowired
    IUserDAO userDAO;
    @Override
    public void persistUser(User user) {
        this.userDAO.persistUser(user);
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getUserByCoachId(int coachId) {
        return null;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public void updateUser(User user) {

    }
}
