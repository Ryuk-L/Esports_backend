package esports.espots.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_post;
    private Integer nb_team;
    private String description;
    private Date date;
    @ManyToOne
    private  Games games;
    @ManyToOne
    private Players owner;




}
