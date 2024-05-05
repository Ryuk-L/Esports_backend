package esports.espots.controller;

import esports.espots.Entity.Players;
import esports.espots.model.LoginRequest;
import esports.espots.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/add")
    public ResponseEntity<Players> add(@RequestBody Players player) {
        return  new ResponseEntity<>(playerService.addPlayer(player),HttpStatus.CREATED);
    }

    @GetMapping("/getAllPlayers")
    public ResponseEntity<List<Players>>  getALLplayers(){
        return  new ResponseEntity<>(playerService.SgetAllplayers(),HttpStatus.OK);
    }


    @GetMapping("/getPlayer/{id}")
    public ResponseEntity<Players>  getplayer(@PathVariable("id")  Integer id){
        return  new ResponseEntity<>(playerService.SgetPlayer(id),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        String password =loginRequest.getPassword();
        Boolean isAuthenticated= playerService.authenticatePlayer(username,password);
        if (isAuthenticated){
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);


    }






}
