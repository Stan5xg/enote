package com.epam.enote.entities;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags", cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();
}
