package esports.espots.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate date_ban;
    private LocalDate date_remove_ban;
    private Boolean ban_forever;



    public Players(Integer id_player, String username, String email, String password ) {
        this.id_player = id_player;
        this.username = username;
        this.email = email;
        this.password = password;
        this.token = 0;
        this.date_ban = null;
        this.date_remove_ban=null;
        this.ban_forever=false;
    }
}
