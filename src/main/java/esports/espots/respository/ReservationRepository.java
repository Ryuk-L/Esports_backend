package esports.espots.respository;

import esports.espots.Entity.Events;
import esports.espots.Entity.Games;
import esports.espots.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    List<Reservation> findByEvent_IdEvent(Integer eventId);
}
