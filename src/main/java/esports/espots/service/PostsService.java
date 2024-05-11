package esports.espots.service;

import esports.espots.Entity.Games;
import esports.espots.Entity.Players;
import esports.espots.Entity.Posts;

import esports.espots.respository.GameRepository;
import esports.espots.respository.PostsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;
    private final GameRepository gamesRepository;
    @Autowired
    public PostsService(GameRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    public Posts addPost(Posts post) {
        Optional<Games> optionalGames = gamesRepository.findById(post.getGames().getIdGame());
        if (optionalGames.isPresent()) {
            post.setGames(optionalGames.get());
            return postsRepository.save(post);
        } else {
            throw new IllegalArgumentException("Games entity with ID " + post.getGames().getIdGame() + " not found");
        }
    }


    public Optional<Posts> findPostById(Integer id) {
        return postsRepository.findById(id);
    }

    public List<Posts> findAllPosts() {
        return postsRepository.findAll();
    }

    public Posts modifyPost(Integer id, Posts updatedPost) {

        Optional<Posts> optionalPost = postsRepository.findById(id);
        if (optionalPost.isPresent()) {
            Posts existingPost = optionalPost.get();
            existingPost.setNb_team(updatedPost.getNb_team());
            existingPost.setDescription(updatedPost.getDescription());
            existingPost.setDate(updatedPost.getDate());
            return postsRepository.save(existingPost);
        } else {
            throw new IllegalArgumentException("Post with ID " + id + " not found");
        }
    }

    // Delete operation
    public void deletePost(Integer id) {
        postsRepository.deleteById(id);
    }




}
