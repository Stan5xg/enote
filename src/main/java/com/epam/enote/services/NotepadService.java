package com.epam.enote.services;

import com.epam.enote.entities.Notepad;
import com.epam.enote.entities.User;

import java.util.List;

public interface NotepadService {

    void create(Notepad notepad);

    void delete(Notepad notepad);

    void update(Notepad notepad);

    Notepad findByName(String name);

    List<Notepad> getAllByUser(User user);
}
