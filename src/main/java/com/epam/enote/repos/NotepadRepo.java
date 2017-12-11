package com.epam.enote.repos;

import com.epam.enote.entities.Notepad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotepadRepo extends JpaRepository<Notepad, Integer> {
    List<Notepad> findAllByUserId(int userId);

    @Query("select n from Notepad n where n.name= :nN")
    List<Notepad> findAllByTitle(@Param("nN") String notepadName);
}
