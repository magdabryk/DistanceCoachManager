package pl.camp.it.distance.coaching.manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Repository
@Entity (name = "ttraining_plan")
public class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int duration; //weeks
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Coach coach;
    private int quantity;

}
