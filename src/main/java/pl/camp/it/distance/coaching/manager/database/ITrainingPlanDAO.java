package pl.camp.it.distance.coaching.manager.database;

import pl.camp.it.distance.coaching.manager.model.TrainingPlan;

import java.util.List;
import java.util.Optional;

public interface ITrainingPlanDAO {
    List<TrainingPlan> getTrainingPlanList();
    void persistTrainingPlan(TrainingPlan trainingPlan);
    void removeTrainingPlan(TrainingPlan trainingPlan);
    void editTrainingPlan(TrainingPlan trainingPlan);
    Optional<TrainingPlan> getTrainingPlanById(int trainingPlanId);
}
