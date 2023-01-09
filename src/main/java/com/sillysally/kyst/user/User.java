package com.sillysally.kyst.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String password;

    public User(String firstName,
                String lastName,
                String email,
                int phoneNumber,
                String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                '}';
    }
}
