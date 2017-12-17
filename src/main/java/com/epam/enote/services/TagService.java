package com.epam.enote.services;

import com.epam.enote.entities.Tag;

import java.util.List;

public interface TagService {
    void create(Tag tag);

    void update(Tag tag);

    void delete(Tag tag);

    List<Tag> findAllByName(String name);
}
