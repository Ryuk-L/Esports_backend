package esports.espots.respository;

import esports.espots.Entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayersRepository extends JpaRepository<Players, Integer> {

    Players findByusername(String username);
}

