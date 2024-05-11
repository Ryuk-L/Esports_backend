package esports.espots.controller;

import esports.espots.Entity.Players;
import esports.espots.Entity.Posts;
import esports.espots.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    // Create operation
    @PostMapping("/add")
    public ResponseEntity<Posts> addPost(@RequestBody Posts post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postsService.addPost(post));
    }
    // Read operation - Find post by id
    @GetMapping("/{id}")
    public ResponseEntity<Posts> findPostById(@PathVariable("id") Integer id) {
        Optional<Posts> post = postsService.findPostById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Read operation - Find all posts
    @GetMapping("/all")
    public ResponseEntity<List<Posts>> findAllPosts() {
        return ResponseEntity.ok(postsService.findAllPosts());
    }

    // Update operation
    @PutMapping("/update/{id}")
    public ResponseEntity<Posts> updatePost(@PathVariable Integer id, @RequestBody Posts updatedPost) {
        Posts modifiedPost = postsService.modifyPost(id, updatedPost);
        return ResponseEntity.ok().body(modifiedPost);
    }


    // Delete operation
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id) {
        postsService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}
