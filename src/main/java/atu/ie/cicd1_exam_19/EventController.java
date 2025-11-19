package atu.ie.cicd1_exam_19;


import jakarta.validation.Valid;
import jakarta.validation.valid;
import jdk.jfr.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService;
    public controller (EventService service){
        this.service=services;
    }

    @GetMapping(/"{ticketCode}")
    public ResponseEntity <Event>getAll(@PathVariable String ticketCode){
        Optional<Event>maybe= service.findById(ticketCode);
        if(maybe.isPresent()){
            return ResponseEntity.ok(maybe.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity <Event>create(@Valid @RequestBody Event e){
        Event Created =service.create(e);
        return ResponseEntity.created(URI.create("/api/Event"+Created.getEventId())).body(Created);
    }
    @PutMapping{"/{ticketCode}"}
    public ResponseEntity <Event> updateEvent(@PathVariable String ticketCode, @Valid @RequestBody Event e){
        Optional<Event>maybe=service.findById(ticketCode);
        if(maybe.isEmpty()){
          return ResponseEntity.notFound().build();
        }

        Event existing =maybe.get();
        existing.setName(e.getName());
        existing.setEmail(e.getEmail());
        Event updated=service.update(existing);
        return ResponseEntity.ok(update);
    }
}
