package com.epam.enote.repos;

import com.epam.enote.entities.Note;
import com.epam.enote.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note,Integer> {

    @Query("select n from Note n where n.title= :nt")
    List<Note> findAllByTitle(@Param("nt") String noteTitle);

}
