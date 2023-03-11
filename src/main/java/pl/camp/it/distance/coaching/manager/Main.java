package pl.camp.it.distance.coaching.manager;

import org.springframework.beans.factory.annotation.Autowired;
import pl.camp.it.distance.coaching.manager.database.ITrainingPlanDAO;
import pl.camp.it.distance.coaching.manager.database.hibernate.TrainingPlanDAOImpl;
import pl.camp.it.distance.coaching.manager.model.TrainingPlan;

import java.util.List;

public class Main {
    public static void main(String[] args) {


     /*   TrainingPlanDAOImpl trainingPlanDAO = new TrainingPlanDAOImpl();
        List<TrainingPlan> list = trainingPlanDAO.getTrainingPlanList();
        for(TrainingPlan element : list){
            System.out.println(element.getId());
            System.out.println(element.getName());
        }*/
    }
}
