package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

        private static  List<Event> listOfEvents = new ArrayList<>();
    @GetMapping
    public String eventList(Model model){
        model.addAttribute("listOfEvents",listOfEvents );
        return "events/index";

    }

//    lives at path /events/form
    @GetMapping("form")
    public String renderCreateEventForm(){
        return "events/form";
    }

//lives at path /events/form
    @PostMapping("form")
    public String createEventForFormSubmission(@RequestParam String eventName){
        listOfEvents.add(new Event(eventName));
        return "redirect:/events";
    }
}
