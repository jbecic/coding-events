package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<String> events = new ArrayList<>();
//    private static HashMap<String, String> events = new HashMap<String, String>(); //for using array list and hashmap
//    private static List<String> eventLocations = new ArrayList<>(); //for using array list and hashmap
//    private static List<Event> events = new ArrayList<>();

//    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("events", events);
//        return"events/index";
//    }

//    @GetMapping //for using array list and hashmap
//    public String displayAllEventsExercises(Model model) {
//        events.put("Admission Prep Bootcamp Virtual & In Person - 1 week", "Want to learn to code? Join us in this hands-on one-week group training class. This class is excellent for anyone who has never tried coding");
//        eventLocations.add("Claim Academy 4356 Lindell Blvd. St. Louis, MO 63108 ");
//        events.put("Thinkful Webinar || Free Crash Course: JavaScript Fundamentals", "Join us and learn how to create a website using the most popular programming language: JavaScript. In this interactive workshop, we'll cover the different data types, variables, functions and more.");
//        eventLocations.add("Thinkful Webinar Online St. Louis, MO ");
//        events.put("Innovator Creator Workshop Series", "This is a series of workshops designed for teachers who want to improve their knowledge and skills in maker activities for STEM clubs.");
//        eventLocations.add("Challenger Learning Center 205 Brotherton Lane St. Louis, MO 63135 ");
//        model.addAttribute("events", events);
//        model.addAttribute("eventLocations", eventLocations);
//        return "events/index";
//    }

//    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("title", "All Events");
//        model.addAttribute("events", events);
//        return"events/index";
//    }

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return"events/index";
    }


    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    // lives at /events/create
//    @PostMapping("create") //for using array list
//    public String createEvent(@RequestParam String eventName) {
//        events.add(eventName);
//        return "redirect:";
//    }

    // lives at /events/create
//    @PostMapping("create") //for using array list and hashmap
//    public String createEvent(@RequestParam String eventName,@RequestParam String eventDescription) {
//        events.put(eventName, eventDescription);
//        return "redirect:";
//    }

//    // lives at /events/create
//    @PostMapping("create") //for using array list and hashmap
//    public String createEvent(@RequestParam String eventName,@RequestParam String eventDescription) {
//        events.add(new Event(eventName, eventDescription));
//        return "redirect:";
//    }

    // lives at /events/create
    @PostMapping("create") //for using array list and hashmap
    public String createEvent(@RequestParam String eventName,@RequestParam String eventDescription) {
        EventData.add(new Event(eventName, eventDescription));
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:";
    }
}
