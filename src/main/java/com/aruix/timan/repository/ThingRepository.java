package com.aruix.timan.repository;

import com.aruix.timan.entity.Thing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThingRepository extends JpaRepository<Thing, Integer>{
    
}