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

    @Basic
    @Column(name="name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();
}
