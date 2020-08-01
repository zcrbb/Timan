package com.aruix.timan.controller;

import com.aruix.timan.entity.Greeting;
import com.aruix.timan.entity.Quote;
import com.aruix.timan.entity.Thing;
import com.aruix.timan.repository.GreetingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/find")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "remark", defaultValue = "hahaha") String remark) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name), remark);
    }

    @PostMapping("/add")
    public @ResponseBody String addThing(@RequestBody Greeting greeting) {
        greetingRepository.save(greeting);
        return "Saved";
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping("/quo")
    public Quote getQuo(RestTemplate restTemplate) throws Exception {
        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote;
    }

}
