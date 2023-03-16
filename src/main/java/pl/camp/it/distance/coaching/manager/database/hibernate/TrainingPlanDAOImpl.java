package pl.camp.it.distance.coaching.manager.database.hibernate;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.distance.coaching.manager.database.ITrainingPlanDAO;
import pl.camp.it.distance.coaching.manager.model.TrainingPlan;

import java.util.List;
import java.util.Optional;

@Repository
public class TrainingPlanDAOImpl implements ITrainingPlanDAO {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<TrainingPlan> getTrainingPlanList() {
        Session session = this.sessionFactory.openSession();
        Query<TrainingPlan> query = session.createQuery("FROM pl.camp.it.distance.coaching.manager.model.TrainingPlan", TrainingPlan.class);
        List<TrainingPlan> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public void persistTrainingPlan(TrainingPlan trainingPlan) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(trainingPlan);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Optional<TrainingPlan> getTrainingPlanById(int trainingPlanId) {
        Session session = this.sessionFactory.openSession();
        Query<TrainingPlan> query = session.createQuery("FROM pl.camp.it.distance.coaching.manager.model.TrainingPlan WHERE id =:id", TrainingPlan.class);
        query.setParameter("id", trainingPlanId);
        Optional<TrainingPlan> result = Optional.empty();
        try{
            result = Optional.of(query.getSingleResult());
        }catch(NoResultException e){}
        session.close();
        return result;
        }


    @Override
    public void removeTrainingPlan(TrainingPlan trainingPlan) {

    }

    @Override
    public void editTrainingPlan(TrainingPlan trainingPlan) {

    }
}
