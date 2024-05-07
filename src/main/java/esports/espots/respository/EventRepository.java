package esports.espots.respository;

import esports.espots.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository  extends JpaRepository<Events,Integer> {
}
