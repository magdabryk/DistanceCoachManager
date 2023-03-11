package pl.camp.it.distance.coaching.manager.database;

import pl.camp.it.distance.coaching.manager.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    void persistUser(User user);
    List<User> getUsers();
    List<User> getUserByCoachId(int coachId);
    Optional<User> getUserByLogin(String login);
    Optional<User> getUserById(int id);
    void updateUser(User user);



}
