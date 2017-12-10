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
@Table(name = "tag")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"notes"})
@ToString(exclude = {"notes"})
public class Tag {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags", cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();
}
