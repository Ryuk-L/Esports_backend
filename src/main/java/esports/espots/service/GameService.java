package esports.espots.service;

import esports.espots.Entity.Games;
import esports.espots.respository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {


    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Games> getAllGames() {
        return gameRepository.findAll();
    }


    public Optional<Games> getGameById(Integer id) {
        return gameRepository.findById(id);
    }

    public Games addGame(Games game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public List<Games> getAllGamesByCategoryId(Integer categoryId) {
        return gameRepository.findAllByCategory_IdCategory(categoryId);
    }




}
