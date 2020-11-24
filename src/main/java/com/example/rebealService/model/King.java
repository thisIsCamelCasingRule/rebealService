package com.example.rebealService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class King {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String kingdom;

    public King(){}

    public King(String name, String kingdom) {
        this.name = name;
        this.kingdom = kingdom;
    }


    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getKingdom() {
        return kingdom;
    }




}
