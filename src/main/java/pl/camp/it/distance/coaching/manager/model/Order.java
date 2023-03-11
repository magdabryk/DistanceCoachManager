package pl.camp.it.distance.coaching.manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "torder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderPosition> orderPositions;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @Enumerated(EnumType.STRING)
    private State state;
    private double total;

    private enum State {
        NEW,
        CONFIRMED,
        PAID,
        CANCELLED,
        DONE

    }
}
