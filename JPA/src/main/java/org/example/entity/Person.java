package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Person {
    @Id
    private int id;
    private String name;

    public void setId(int id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name=name;
    }
}
