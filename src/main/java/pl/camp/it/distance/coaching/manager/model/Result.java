package pl.camp.it.distance.coaching.manager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity(name = "tresult")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Exercise exercise;
    private int maxRepetition;

    public Result() {
    }

    public Result(int id, LocalDateTime date, User user, Exercise exercise, int maxRepetition) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.exercise = exercise;
        this.maxRepetition = maxRepetition;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getMaxRepetition() {
        return maxRepetition;
    }

    public void setMaxRepetition(int maxRepetition) {
        this.maxRepetition = maxRepetition;
    }
}
