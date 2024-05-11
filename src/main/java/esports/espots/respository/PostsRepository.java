package esports.espots.respository;

import esports.espots.Entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository  extends JpaRepository<Posts,Integer> {

}
