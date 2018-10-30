package com.caelum.tccjavaweb.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Layout Dialect usage example.
 */
@Controller
@Secured("ROLE_USER")
class EventController_LayoutDialect {


    private final EventService eventService;

    private final static String ROOT_URL = "event/";
    private final static String CADASTRO_VIEW_INDEX = ROOT_URL  + "index";
    private final static String CADASTRO_VIEW_CREATE = ROOT_URL  + "create";
    private final static String CADASTRO_VIEW_EDIT = ROOT_URL  + "edit";
    private final static String CADASTRO_VIEW_DELETE = ROOT_URL  + "delete";
    private final static String CADASTRO_VIEW_TESTE = "teste";


    EventController_LayoutDialect(EventService eventService) {
        this.eventService = eventService;
    }

    @ModelAttribute("module")
    public String module() {
        return "events";
    }

    @RequestMapping(value = "event", method = RequestMethod.GET)
    public ModelAndView events() {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW_INDEX);
        mv.addObject("events", eventService.findAll());
        return mv;
    }

    @RequestMapping(value = "event/{id}", method = RequestMethod.GET)
    public ModelAndView event(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView( CADASTRO_VIEW_EDIT);
        mv.addObject("event", eventService.findOne(id));

        return mv;
    }


    @RequestMapping(value = "event/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView( CADASTRO_VIEW_CREATE);
        mv.addObject(new Event());

        return mv;
    }

    @RequestMapping(value = "event/save", method = RequestMethod.POST)
    public ModelAndView save() {
        ModelAndView mv = new ModelAndView( CADASTRO_VIEW_CREATE);
        Event event = new Event();
        event.setTitle("Teste");
        mv.addObject(event);

        return mv;
    }

    //    public String create(@Validated Event event, Errors errors, RedirectAttributes attr) {
//    @RequestMapping( method = RequestMethod.POST)
//    public String save() {
//
//
//        return "save";
//    }



}
