package com.epam.enote.repos;

import com.epam.enote.entities.Notepad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotepadRepo extends JpaRepository<Notepad,Integer> {
}
