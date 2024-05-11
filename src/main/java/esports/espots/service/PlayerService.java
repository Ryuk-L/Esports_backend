package esports.espots.service;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import esports.espots.Entity.Players;
import esports.espots.respository.PlayersRepository;

import java.sql.Date;
import java.util.List;

@Service
public class PlayerService {
    private final PlayersRepository playersRepository;

    @Autowired
    public PlayerService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public Players addPlayer(@RequestBody Players player) {
        playersRepository.save(player);
        return player;
    }

    public List<Players> SgetAllplayers() {
        return playersRepository.findAll();
    }

    public Players SgetPlayer(Integer id){
        return  playersRepository.findById(id).get();
    }

    public Boolean authenticatePlayer(String username, String password) {
       Players player= playersRepository.findByusername(username);
       return player!=null && player.getPassword().equals(password);
    }

    public boolean isPlayerBanned(Integer playerId) {
        Optional<Players> optionalPlayer = playersRepository.findById(playerId);
        if (optionalPlayer.isPresent()) {
            Players player = optionalPlayer.get();
            LocalDate currentDate = LocalDate.now();
            if (player.getBan_forever() || (player.getDate_ban() != null && player.getDate_ban().isBefore(currentDate))) {
                return true;
            }
        }
        return false;
    }

    public boolean banPlayerForever(Integer playerId) {
        Optional<Players> optionalPlayer = playersRepository.findById(playerId);
        if (optionalPlayer.isPresent()) {
            Players player = optionalPlayer.get();
            player.setDate_ban(LocalDate.now());
            player.setBan_forever(true);
            playersRepository.save(player);
            return true;
        }
        return false;
    }


}
