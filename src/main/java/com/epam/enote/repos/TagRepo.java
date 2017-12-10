package com.epam.enote.repos;

import com.epam.enote.entities.Tag;
import com.epam.enote.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends JpaRepository<Tag,Integer> {

    @Query("select t from Tag t where t.name= :tn")
    Tag findOneByName(@Param("tn") String name);

}
