package com.epam.enote.entities;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name="username", nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(name = "password_hash")
    public String passwordHash;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Notepad> notepads = new HashSet<>();

    public boolean addNotepad(Notepad notepad) {
        notepad.setUser(this);
        return notepads.add(notepad);
    }
}

