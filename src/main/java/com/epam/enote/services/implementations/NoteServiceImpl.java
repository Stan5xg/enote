package com.epam.enote.services.implementations;

import com.epam.enote.entities.Note;
import com.epam.enote.entities.Notepad;
import com.epam.enote.entities.Tag;
import com.epam.enote.entities.User;
import com.epam.enote.repos.NoteRepo;
import com.epam.enote.repos.TagRepo;
import com.epam.enote.repos.UserRepo;
import com.epam.enote.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private NoteRepo noteRepo;
    private UserRepo userRepo;

    @Override
    public void create(Note note) {
        noteRepo.save(note);
    }

    @Override
    public void update(Note note) {
        userRepo.saveAndFlush(note.getNotepad().getUser());
    }

    @Override
    public void delete(Note note) {
        noteRepo.delete(note);
    }

    @Override
    public List<Note> findAllByTitle(String title) {
        return noteRepo.findAllByTitle(title);
    }


    @Override
    public List<Note> findAllByTag(Tag tag) {
        LinkedList<Note> notes = new LinkedList<>();
        notes.addAll(tag.getNotes());
        return notes;
    }
}
