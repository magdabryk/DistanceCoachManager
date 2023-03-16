package pl.camp.it.distance.coaching.manager.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.camp.it.distance.coaching.manager.model.OrderPosition;
import pl.camp.it.distance.coaching.manager.model.User;

import java.util.HashMap;
import java.util.Map;

@SessionScope
@Component
public class SessionObject {
    private User user = null;
    private Map<Integer, OrderPosition> cart = new HashMap<>();

    public Map<Integer, OrderPosition> getCart() {
        return cart;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogged() {
        return this.user != null;
    }
}
