package esports.espots.service;

import esports.espots.Entity.Participation;
import esports.espots.Entity.Players;
import esports.espots.Entity.Posts;
import esports.espots.respository.ParticipationRepository;
import esports.espots.respository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService {

    @Autowired
    private ParticipationRepository participationRepository;

    private final PostsRepository postsRepository;
    public ParticipationService( PostsRepository postsRepository){
        this.postsRepository=postsRepository;
    }

    public void addParticipation(Participation participation) {
        Integer idPost = participation.getPost().getId_post();
        Optional<Posts> optionalPost = postsRepository.findById(idPost);

        if (optionalPost.isPresent()) {
            Posts post = optionalPost.get();
            Integer nbTeam = post.getNb_team();

            if (nbTeam != null && nbTeam > 0) {
                post.setNb_team(nbTeam - 1);
                postsRepository.save(post);
                participationRepository.save(participation);
            } else {
                throw new IllegalArgumentException("No available teams for participation");
            }
        } else {
            throw new IllegalArgumentException("Posts entity with ID " + idPost + " not found");
        }
    }
    public List<Players> findPlayersByPostId(Integer postId) {
        return participationRepository.findPlayersByPostId(postId);
    }

   
}
