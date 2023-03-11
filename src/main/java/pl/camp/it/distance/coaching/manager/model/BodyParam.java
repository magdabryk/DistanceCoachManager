package pl.camp.it.distance.coaching.manager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity(name = "tbody_param")
public class BodyParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private double weight;  // kg
    private int height;  // w cm
    private double BMI;
    private double waist; //cm
    private double chest; //cm
    private double hips; //cm
    private double tight; //cm
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public BodyParam() {
    }

    public BodyParam(int id, LocalDateTime date, double weight, int height, double waist, double chest, double hips, double tight, User user) {
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.BMI = weight/((height/1000.0)*(height/1000.0));
        this.waist = waist;
        this.chest = chest;
        this.hips = hips;
        this.tight = tight;
        this.user = user;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getHips() {
        return hips;
    }

    public void setHips(double hips) {
        this.hips = hips;
    }

    public double getTight() {
        return tight;
    }

    public void setTight(double tight) {
        this.tight = tight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
