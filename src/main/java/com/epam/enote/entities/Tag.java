package com.epam.enote.entities;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String name;


}
