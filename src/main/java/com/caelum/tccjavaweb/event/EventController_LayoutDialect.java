package com.caelum.tccjavaweb.event;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Layout Dialect usage example.
 */
@Controller
@Secured("ROLE_USER")
class EventController_LayoutDialect {

    private final EventService eventService;

    EventController_LayoutDialect(EventService eventService) {
        this.eventService = eventService;
    }

    @ModelAttribute("module")
    public String module() {
        return "events";
    }

    @RequestMapping(value = "event", method = RequestMethod.GET)
    public String events(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "event/index";
    }

    @RequestMapping(value = "event/{id}", method = RequestMethod.GET)
    public String event(@PathVariable("id") Long id, Model model) {
        model.addAttribute("event", eventService.findOne(id));
        return "event/event";
    }


    @RequestMapping(value = "event/create", method = RequestMethod.GET)
    public String event(Model model) {
        return "event/create";
    }
}
