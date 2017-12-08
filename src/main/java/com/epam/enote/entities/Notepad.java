package com.epam.enote.entities;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Data
@Entity
@Table(name = "notepad")
public class Notepad {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
}
