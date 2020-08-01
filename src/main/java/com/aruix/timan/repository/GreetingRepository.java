package com.aruix.timan.repository;

import com.aruix.timan.entity.Greeting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}