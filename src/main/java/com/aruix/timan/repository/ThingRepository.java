package com.aruix.timan.repository;

import com.aruix.timan.entity.Thing;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;


// @RepositoryRestResource(collectionResourceRel = "thing", path = "thing")
public interface ThingRepository extends JpaRepository<Thing, Integer>{
    
}