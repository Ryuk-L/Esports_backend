package esports.espots.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id_player", "idEvent"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date reservationDate;

    @ManyToOne
    private Players player;

    @ManyToOne
    private Events event;
}
