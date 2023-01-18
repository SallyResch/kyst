package com.sillysally.kyst.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String password;
    private LocalDateTime created = LocalDateTime.now();

    public User(String firstName,
                String lastName,
                String email,
                int phoneNumber,
                String password, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.created = created;
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
                ", created='" + created + '\'' +
                '}';
    }
}
