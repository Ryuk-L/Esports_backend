package esports.espots.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_player;
    private String username;
    private String email;
    private String password;
    private Integer token;
    private Date date_ban;
    private Date date_remove_ban;


    public Players(Integer id_player, String username, String email, String password ) {
        this.id_player = id_player;
        this.username = username;
        this.email = email;
        this.password = password;
        this.token = 0;
        this.date_ban = null;
        this.date_remove_ban=null
        ;


    }
}
