package pl.camp.it.distance.coaching.manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "torder_position")
public class OrderPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.EAGER)
    private TrainingPlan trainingPlan;
    private int amount;

    public OrderPosition(TrainingPlan trainingPlan, int amount) {
        this.trainingPlan = trainingPlan;
        this.amount = amount;
    }

    public void increamentAmount() {
        this.amount++;
    }
}
