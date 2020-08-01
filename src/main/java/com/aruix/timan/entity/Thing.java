package com.aruix.timan.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer user;
    private String thing;
    private Integer urgency;
    private Integer interest;
    private Integer duration;
    private Integer mental;
    private Integer physical;
    private Integer patient;
    private Integer time;
    private Date ddl;
    private String remark;
}