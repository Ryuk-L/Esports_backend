package esports.espots.controller;

import esports.espots.Entity.Category;
import esports.espots.Entity.Games;
import esports.espots.service.CategoryService;
import esports.espots.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/games")
public class GameController {
    @Autowired
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Games> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Games> getGameById(@PathVariable Integer id) {
        Optional<Games> game = gameService.getGameById(id);
        return game.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Games> addGame(@RequestBody Games game) {
        Games newGame = gameService.addGame(game);
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Integer id) {
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Games>> getAllGamesByCategory(@PathVariable Integer categoryId) {
        List<Games> games = gameService.getAllGamesByCategoryId(categoryId);
        if (games.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(games);
        }
    }




}
