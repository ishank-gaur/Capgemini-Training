package org.example;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Person {
    @Id
    private int id;

    // Default Constructor (Required by Hibernate)
    public Person() {
    }
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



    // Parameterized Constructor
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

