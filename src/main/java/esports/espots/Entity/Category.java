package esports.espots.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idCategory;
    private String nameCategory;
    @OneToMany(mappedBy="category", cascade = CascadeType.ALL)
    private Set<Games> Games;
}
