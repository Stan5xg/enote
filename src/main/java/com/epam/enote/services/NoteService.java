package com.epam.enote.services;

import com.epam.enote.entities.Note;
import com.epam.enote.entities.Tag;

import java.util.List;

public interface NoteService {

    void create(Note note);

    void update(Note note);

    void delete(Note note);

    List<Note> findAllByTitle(String title);

    List<Note> findAllByTag(Tag tag);
}
