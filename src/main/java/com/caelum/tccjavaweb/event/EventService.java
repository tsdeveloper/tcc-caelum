package com.caelum.tccjavaweb.event;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

//    @PostConstruct
//    private void init() {
//        eventRepository.save(new Event("Shopping", "Buy Milk and Butter...", "2017.01.01 13:22:42"));
//        eventRepository.save(new Event("Books", "Read 'Lords of The Ring'", "2017.01.02 15:22:42"));
//    }

    Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findOne(Long id) {
        return eventRepository.findOne(id);
    }

    public Event save(Event event) throws Exception {

        try {
            return eventRepository.save(event);

        }catch (Exception e){
             throw  new Exception(e.getMessage());
        }

    }
}
