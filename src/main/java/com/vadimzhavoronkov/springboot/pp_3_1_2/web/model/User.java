package com.vadimzhavoronkov.springboot.pp_3_1_2.web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    @NotNull(message = "User's name cannot be empty.")
    @Pattern(regexp="^[A-ZА-Я][a-zа-я]*$",message = "Invalid Input")
    private String name;

    @Column(name = "lastname")
    @NotNull(message = "User's Last Name cannot be empty.")
    @Pattern(regexp="^[A-ZА-Я][a-zа-я]*$",message = "Invalid Input")
    private String lastname;

    @Column(name = "age")
    @Min(value = 1, message = "User's age cannot be less than 1.")
    @Max(value = 150, message = "User's age cannot be over 150.")
    private int age;

    public User() {}

    public User(int id, @NotNull String name, @NotNull String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return this.name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public @NotNull String getLastname() {
        return this.lastname;
    }

    public void setLastname(@NotNull String lastName) {
        this.lastname = lastName;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.lastname + " " + this.age;
    }
}

