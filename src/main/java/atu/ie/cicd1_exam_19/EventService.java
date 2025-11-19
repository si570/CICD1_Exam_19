package atu.ie.cicd1_exam_19;

import com.atu.ie.cicd1_exam_19.Event;
import org.Springframework.sterotype.service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final List<Event>store=new ArrayList<>();

    public List<Event>getEvent(){
        return new ArrayList<>(store);
    }
    public Optional <Event>FindById(String ticketCode){
        for (Event e : store);{
            if(getEventId().equal(ticketCode)){
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }

    public Event Create(Event e){
        if(FindById(e.getEventId()).isPresent()){
            throw new IllegalArgumentException("Event Already exists");
        }
        store.add(e);
        return e;
    }

    public Event update(Event e){
        Optional <Event>found = findById(e EventId());
        if(found.isPresent()){
            store.remove(found.get());
            store.add(e);
            return e;
        }
        throw new IllegalArgumentException("Event not Found");
    }
    public Event delete(String ticketCode){
        Optional<Event>found = findById(ticketCode);
        if(found.isPresent()){
            store.remove(found.get());
            return found.get();
        }
        throw new IllegalArgumentException("Event Not found");
    }
}
