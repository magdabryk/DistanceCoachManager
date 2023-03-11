package pl.camp.it.distance.coaching.manager.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.camp.it.distance.coaching.manager.model.User;

@SessionScope
@Component
public class SessionObject {
    public User user = null;

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogged() {
        return this.user != null;
    }
}
