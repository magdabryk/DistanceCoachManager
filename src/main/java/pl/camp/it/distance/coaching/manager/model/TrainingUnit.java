package pl.camp.it.distance.coaching.manager.model;

import jakarta.persistence.*;

@Entity(name = "ttraninig_unit")
public class TrainingUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Exercise exercise;
    private int repetition;

    public TrainingUnit() {
    }

    public TrainingUnit(int id, Exercise exercise, int repetition) {
        this.id = id;
        this.exercise = exercise;
        this.repetition = repetition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }
}
