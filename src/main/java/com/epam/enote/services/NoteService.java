package com.epam.enote.services;

import com.epam.enote.entities.Note;
import com.epam.enote.entities.Tag;

public interface NoteService {

    void create(Note note);

    void update(Note note);

    void delete(Note note);

    void getByTitle(String title);

    void getByTag(Tag tag);
}
