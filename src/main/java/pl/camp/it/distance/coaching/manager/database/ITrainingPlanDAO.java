package pl.camp.it.distance.coaching.manager.database;

import pl.camp.it.distance.coaching.manager.model.TrainingPlan;

import java.util.List;

public interface ITrainingPlanDAO {
    List<TrainingPlan> getTrainingPlanList();
    void persistTrainingPlan(TrainingPlan trainingPlan);
    void removeTrainingPlan(TrainingPlan trainingPlan);
    void editTrainingPlan(TrainingPlan trainingPlan);
}
