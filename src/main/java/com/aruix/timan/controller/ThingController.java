package com.aruix.timan.controller;

import com.aruix.timan.repository.ThingRepository;

import java.util.List;

import com.aruix.timan.entity.Thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class ThingController {
    @Autowired
    private ThingRepository thingRepository;

    @GetMapping("/findAll")
    public List<Thing> findAll() {
        return thingRepository.findAll();
    }

}