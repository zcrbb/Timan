package com.aruix.timan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Thing {
    @Id
    private int id;
    private int user;
    private String thing;
    private int urgency;
    private int interest;
    private int duration;
    private int mental;
    private int physical;
    private int patient;
}