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
public class CategoryService {


    private final CategoryRepository categoryRepository;
    private final GameRepository gameRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, GameRepository gameRepository) {
        this.categoryRepository = categoryRepository;
        this.gameRepository = gameRepository;
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

//    public void deleteCategory(Integer id) {
//        categoryRepository.deleteById(id);
//    }

    public  Category getCategoryById(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.orElse(null);
    }


    public void deleteCategory(Integer categoryId) {
        // Check if the category exists
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        List<Games> games = gameRepository.findByCategory(category);


        for (Games game : games) {
            gameRepository.delete(game);
        }

        // Finally, delete the category
        categoryRepository.delete(category);
    }




    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


}
