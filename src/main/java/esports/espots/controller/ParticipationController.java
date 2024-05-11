package esports.espots.controller;

import esports.espots.Entity.Participation;
import esports.espots.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins ="*")
@RestController
public class ParticipationController {

    @Autowired
    private ParticipationService participationService;

    @PostMapping("/addParticipation")
    public ResponseEntity<String> addParticipation(@RequestBody Participation participation) {
        try {
            participationService.addParticipation(participation);
            return new ResponseEntity<>("Participation added successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

   
}
