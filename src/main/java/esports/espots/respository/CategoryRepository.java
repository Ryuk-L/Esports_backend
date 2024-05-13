package esports.espots.respository;

import esports.espots.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
