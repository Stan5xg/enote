package com.epam.enote.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notepad")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"notes", "user"})
@ToString(exclude = {"notes", "user"})
public class Notepad {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "notepad", cascade = {CascadeType.ALL})
    private Set<Note> notes = new HashSet<>();

    public boolean addNote(Note note) {
        note.setNotepad(this);
        return notes.add(note);
    }
}
