package esports.espots.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import esports.espots.Entity.Players;
import esports.espots.respository.PlayersRepository;

import java.util.List;

@Service
public class PlayerService {
    private final PlayersRepository playersRepository;

    @Autowired
    public PlayerService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public Players addPlayer(@RequestBody Players player) {
        player.setToken(0);
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
}
