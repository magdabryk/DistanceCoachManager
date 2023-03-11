package pl.camp.it.distance.coaching.manager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.distance.coaching.manager.database.ITrainingPlanDAO;
import pl.camp.it.distance.coaching.manager.model.TrainingPlan;
import pl.camp.it.distance.coaching.manager.services.ITrainingPlanService;

import java.util.List;
@Service
public class TrainigPlanService implements ITrainingPlanService {
    @Autowired
    ITrainingPlanDAO trainingPlanDAO;
    @Override
    public List<TrainingPlan> getTrainingPlanList() {
        return  this.trainingPlanDAO.getTrainingPlanList();
    }
}
