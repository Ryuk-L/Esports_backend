package esports.espots.service;

import esports.espots.Entity.Events;
import esports.espots.Entity.Games;
import esports.espots.Entity.Reservation;
import esports.espots.respository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EventService eventsService;

    public Reservation addReservation(Reservation reservation) {
        Integer eventId = reservation.getEvent().getIdEvent();
        Optional<Events> eventOptional = eventsService.getEventById(eventId);

        return eventOptional.map(event -> {
            Integer availablePlaces = event.getPlaces();
            if (availablePlaces == null || availablePlaces <= 0) {
                throw new IllegalStateException("No available places for reservation in the event.");
            }

            event.setPlaces(availablePlaces - 1);
            eventsService.updateEvent(event.getIdEvent(), event);

            return reservationRepository.save(reservation);
        }).orElseThrow(() -> new IllegalArgumentException("Event not found."));
    }



    public Optional<Reservation> getReservationById(Integer id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getAllReservationsByEvent(Integer eventId) {
        return reservationRepository.findByEvent_IdEvent(eventId);
    }
}
