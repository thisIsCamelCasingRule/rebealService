package com.example.rebealService.model;

import javax.persistence.*;

@Entity
@Table(name = "peasants")
public class Peasant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String position;
    private String kingdom;
    private boolean status;

    public Peasant(String name, String position, String kingdom, boolean status) {
        this.name = name;
        this.position = position;
        this.status = status;
        this.kingdom = kingdom;
    }

    public Peasant() {
    }
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "position", nullable = false)
    public String getPosition() {
        return position;
    }
    public void setPosition(String position){ this.position = position; }

    @Column(name = "kingdom", nullable = false)
    public String getKingdom() {
        return kingdom;
    }
    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    @Column(name = "status", nullable = false)
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }


}
