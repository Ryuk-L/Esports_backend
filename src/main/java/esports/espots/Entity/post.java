package esports.espots.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_post;
    private Integer nb_team;
    @ManyToOne
    private  Games games;
    @ManyToOne
    private Players Team;
    @ManyToOne
    private Players owner;




}
