package pl.camp.it.distance.coaching.manager.services;

import pl.camp.it.distance.coaching.manager.model.User;

public interface IAuthenticationService {

    void authenticate(String login, String password);
    void logout();
    void registerUser(User user);

}
