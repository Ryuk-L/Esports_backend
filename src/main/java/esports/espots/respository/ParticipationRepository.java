package esports.espots.respository;


import esports.espots.Entity.Participation;
import esports.espots.Entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ParticipationRepository extends JpaRepository<Participation,Integer> {
    @Query("SELECT p.player FROM Participation p WHERE p.post.id_post = :postId")
    List<Players> findPlayersByPostId(Integer postId);
}
