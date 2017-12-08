package com.epam.enote.entities;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "notepad")
public class Notepad {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "notepad", cascade = {CascadeType.ALL})
    private Set<Note> notes = new HashSet<>();

    public boolean addNote(Note note) {
        note.setNotepad(this);
        return notes.add(note);
    }
}
