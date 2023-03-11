package pl.camp.it.distance.coaching.manager.model;

import jakarta.persistence.*;

@Entity(name = "texercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private Type type;
    private String name;
    private int weight;

    public Exercise() {
    }

    public Exercise(int id, Type type, String name, int weight) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private enum Type {
        KETTLEBELL,
        BODYWEIGHT,
        BARBEL,
        FLEXIBELLSTEEL,

    }
}
