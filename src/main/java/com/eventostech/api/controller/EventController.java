package com.eventostech.api.controller;


import com.eventostech.api.domain.event.Event;
import com.eventostech.api.domain.event.EventRequestDTO;
import com.eventostech.api.domain.event.EventResponseDTO;
import com.eventostech.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Event> create (@RequestParam("title") String title,
                                         @RequestParam(value = "description", required = false) String description,
                                         @RequestParam("eventDate") Long eventDate,
                                         @RequestParam("city") String city,
                                         @RequestParam("state") String state,
                                         @RequestParam("remote") Boolean remote,
                                         @RequestParam("eventUrl") String eventUrl,
                                         @RequestParam(value = "image", required = false) MultipartFile image
                                         ) {
        EventRequestDTO eventRequestDTO = new EventRequestDTO(title, description, eventDate, city, state, remote, eventUrl, image);
        Event newEvent = this.eventService.createEvent(eventRequestDTO);
        return ResponseEntity.ok(newEvent);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getEvents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<EventResponseDTO> allEvents = this.eventService.getUpComingEvents(page, size);
        return ResponseEntity.ok(allEvents);
    }
}
