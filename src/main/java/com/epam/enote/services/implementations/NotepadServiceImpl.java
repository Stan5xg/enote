package com.epam.enote.services.implementations;

import com.epam.enote.entities.Notepad;
import com.epam.enote.entities.User;
import com.epam.enote.repos.NotepadRepo;
import com.epam.enote.repos.UserRepo;
import com.epam.enote.services.NotepadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NotepadServiceImpl implements NotepadService{

    private final NotepadRepo notepadRepo;
    private final UserRepo userRepo;



    @Override
    public void create(Notepad notepad) {
        User user = notepad.getUser();
        user.addNotepad(notepad);
        userRepo.save(user);
    }

    @Override
    public void delete(Notepad notepad) {
        notepadRepo.delete(notepad);
    }

    @Override
    public void update(Notepad notepad) {
        notepadRepo.saveAndFlush(notepad);
    }

    @Override
    public Notepad findByName(String name) {
        return notepadRepo.findByName(name);
    }

    @Override
    public List<Notepad> getAllByUser(User user) {
        return new ArrayList<>(user.getNotepads());
    }
}
