package esports.espots.service;

import esports.espots.Entity.Events;
import esports.espots.Exception.EventNotFoundException;
import esports.espots.respository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Events addEvent(Events event) {
        return eventRepository.save(event);
    }

    public Events updateEvent(Integer id, Events event) {
        Optional<Events> existingEventOptional = eventRepository.findById(id);
        if (existingEventOptional.isPresent()) {
            Events existingEvent = existingEventOptional.get();
            existingEvent.setName(event.getName());
            existingEvent.setReward(event.getReward());
            existingEvent.setLocation(event.getLocation());
            existingEvent.setDate_start(event.getDate_start());
            existingEvent.setDate_end(event.getDate_end());
            existingEvent.setPlaces(event.getPlaces());
            existingEvent.setGames(event.getGames());
            return eventRepository.save(existingEvent);
        } else {

            throw new EventNotFoundException("Event with ID " + id + " not found");
        }
    }


    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }

    public Optional<Events> getEventById(Integer id) {
        return eventRepository.findById(id);
    }

    public List<Events> getAllEvents() {
        return eventRepository.findAll();
    }
}
