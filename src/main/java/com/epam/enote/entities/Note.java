package com.epam.enote.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "notepad")
public class Note {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String content;

    @ManyToOne
    @JoinColumn(name = "notepad_id", referencedColumnName = "id", nullable = false)
    private Notepad notepad;
}
