package pl.camp.it.distance.coaching.manager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Map;

@Entity(name = "ttraninig")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    @OneToMany(fetch = FetchType.EAGER)
    private Map<Integer, TrainingUnit > trainingUnits;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Coach coach;

    public Training() {
    }

    public Training(int id, LocalDateTime date, Map<Integer, TrainingUnit> trainingUnits, User user, Coach coach) {
        this.id = id;
        this.date = date;
        this.trainingUnits = trainingUnits;
        this.user = user;
        this.coach = coach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Map<Integer, TrainingUnit> getTrainingUnits() {
        return trainingUnits;
    }

    public void setTrainingUnits(Map<Integer, TrainingUnit> trainingUnits) {
        this.trainingUnits = trainingUnits;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
