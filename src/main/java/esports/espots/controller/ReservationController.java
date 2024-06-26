package esports.espots.controller;

import esports.espots.Entity.Events;
import esports.espots.Entity.Games;
import esports.espots.Entity.Players;
import esports.espots.Entity.Reservation;
import esports.espots.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<?> addReservation(@RequestBody Reservation reservation) {
        try {
            Reservation addedReservation = reservationService.addReservation(reservation);
            return ResponseEntity.ok().body(addedReservation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Integer id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return reservation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Integer id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/Event/{eventId}")
    public ResponseEntity<List<Players>> getAllReservationsByEvent(@PathVariable Integer eventId) {
        List<Reservation> reservations = reservationService.getAllReservationsByEvent(eventId);
        List<Players> players = new ArrayList<>();

        for (Reservation reservation : reservations) {
            players.add(reservation.getPlayer());
        }

        if (players.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}
