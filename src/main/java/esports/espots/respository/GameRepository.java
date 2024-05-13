package esports.espots.respository;

import esports.espots.Entity.Category;
import esports.espots.Entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository  extends JpaRepository<Games, Integer> {
    List<Games> findAllByCategory_IdCategory(Integer categoryId);
    List<Games> findByCategory(Category category);
}
