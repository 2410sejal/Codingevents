package org.launchcode.codingevents.controllers;

import jdk.jfr.Description;
import jdk.jfr.Name;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

        private static  HashMap<Name,Description> events = new HashMap<>();
         events.put("Menteaship","A fun meetup for connecting with mentors");
         events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
         events.put("Javascripty", "An imaginary meetup for Javascript developers");
    @GetMapping
    public String eventList(Model model){
        model.addAttribute("listOfEvents",events );
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
        events.put(eventName);
        return "redirect:/events";
    }
}
