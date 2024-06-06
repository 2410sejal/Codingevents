package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("events")
public class EventController {


    @GetMapping
    public String eventList(Model model){
        model.addAttribute("listOfEvents", EventData.getAll());
        return "events/index";

    }

//    lives at path /events/form
    @GetMapping("form")
    public String renderCreateEventForm(Model model){
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/form";
    }

//lives at path /events/form
    @PostMapping("form")
    public String createEventForFormSubmission(@ModelAttribute @Valid Event newEvent,
                                               Errors errors, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            return "events/form";
        }
        EventData.add(newEvent);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:/events";
    }


}
