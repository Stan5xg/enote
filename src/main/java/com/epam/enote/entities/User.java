package com.epam.enote.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"notepads"})
@ToString(exclude = {"notepads"})
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(name = "password_hash")
    public String passwordHash;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private Set<Notepad> notepads = new HashSet<>();

    public boolean addNotepad(Notepad notepad) {
        notepad.setUser(this);
        return notepads.add(notepad);
    }
}

