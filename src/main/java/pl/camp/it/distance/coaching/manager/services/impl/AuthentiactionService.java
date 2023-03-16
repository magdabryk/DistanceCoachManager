package pl.camp.it.distance.coaching.manager.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.distance.coaching.manager.database.IUserDAO;
import pl.camp.it.distance.coaching.manager.model.User;
import pl.camp.it.distance.coaching.manager.services.IAuthenticationService;
import pl.camp.it.distance.coaching.manager.session.SessionObject;

import java.util.Optional;

@Service
public class AuthentiactionService implements IAuthenticationService {
    @Autowired
    IUserDAO userDAO;
    @Autowired
    SessionObject sessionObject;
    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = userDAO.getUserByLogin(login);
        if(userBox.isPresent() && userBox.get().getPassword().equals(DigestUtils.md5Hex(password))){
            this.sessionObject.setUser(new User.UserBuilder()
                    .clone(userBox.get())
                    .password(null)
                    .build());
        }
    }

    @Override
    public void logout() {
    this.sessionObject.setUser(null);
    }

    @Override
    public void registerUser(User user) {
    user.setPassword(DigestUtils.md5Hex(user.getPassword()));
    this.userDAO.persistUser(user);
    }
}
