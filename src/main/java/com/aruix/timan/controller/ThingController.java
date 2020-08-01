package com.aruix.timan.controller;

import com.aruix.timan.repository.ThingRepository;

import java.util.List;

import com.aruix.timan.entity.Thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class ThingController {
    private final ThingRepository thingRepository;

    public ThingController(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @GetMapping("/findAll")
    public List<Thing> findAll() {
        return thingRepository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody String addThing(@RequestBody Thing thing) {
        thingRepository.save(thing);
        return "Saved";
    }

}