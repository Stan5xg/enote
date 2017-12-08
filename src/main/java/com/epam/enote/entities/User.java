package com.epam.enote.entities;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(name = "password_hash")
    public String passwordHash;


}
