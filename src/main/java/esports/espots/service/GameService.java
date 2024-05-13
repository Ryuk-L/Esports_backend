package esports.espots.service;

import esports.espots.Entity.Category;
import esports.espots.Entity.Games;
import esports.espots.respository.CategoryRepository;
import esports.espots.respository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {


    private final GameRepository gameRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public GameService(GameRepository gameRepository, CategoryRepository categoryRepository) {
        this.gameRepository = gameRepository;
        this.categoryRepository=categoryRepository;
    }

    public List<Games> getAllGames() {
        return gameRepository.findAll();
    }


    public Optional<Games> getGameById(Integer id) {
        return gameRepository.findById(id);
    }

//    public Games addGame(Games game) {
//        return gameRepository.save(game);
//    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public List<Games> getAllGamesByCategoryId(Integer categoryId) {
        return gameRepository.findAllByCategory_IdCategory(categoryId);
    }

    public Games updateGame(Games updatedGame) {
        // Check if the game already exists in the database
        if (updatedGame.getIdGame() == null || !gameRepository.existsById(updatedGame.getIdGame())) {
            throw new IllegalArgumentException("Game does not exist or invalid ID provided.");
        }

        // Save the updated game
        return gameRepository.save(updatedGame);
    }

    public Games addGame(Games game) {
        // Retrieve the Category from the database by its ID
        Category category = categoryRepository.findById(game.getCategory().getIdCategory())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        // Set the managed Category to the Games entity
        game.setCategory(category);

        // Save the Games entity
        return gameRepository.save(game);
    }





}
