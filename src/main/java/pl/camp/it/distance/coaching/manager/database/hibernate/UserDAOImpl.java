package pl.camp.it.distance.coaching.manager.database.hibernate;



import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.distance.coaching.manager.database.IUserDAO;
import pl.camp.it.distance.coaching.manager.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void persistUser(User user) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getUserByCoachId(int coachId) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.camp.it.distance.coaching.manager.model.User WHERE id =:id", User.class);
        query.setParameter("id", coachId);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.camp.it.distance.coaching.manager.model.User WHERE login =:login", User.class);
        query.setParameter("login", login);
        Optional<User> result = Optional.empty();
        try {
            result = Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
        }
        session.close();
        return result;
    }

    @Override
    public Optional<User> getUserById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.camp.it.distance.coaching.manager.model.User WHERE id :id", User.class);
        query.setParameter("id", id);
        Optional<User> result = Optional.empty();
        try {
            result = Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
        }
        session.close();
        return result;
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getUsers() {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.camp.it.distance.coaching.manager.model.User", User.class);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }
}
