package esports.espots.respository;

import esports.espots.Entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository  extends JpaRepository<Games, Integer> {
}
