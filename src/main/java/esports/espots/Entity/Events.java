package esports.espots.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idEvent;
    private  String name;
    private  Integer reward;
    private  String location;
    private  Date date_start;
    private  Date date_end;
    private  Integer places;
    @ManyToOne
    private  Games games;

}
