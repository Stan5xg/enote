package com.epam.enote.services.implementations;

import com.epam.enote.entities.Tag;
import com.epam.enote.repos.TagRepo;
import com.epam.enote.services.TagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagSeviceImpl implements TagService {

    @Autowired
    TagRepo tagRepo;


    @Override
    public void create(Tag tag) {
        tagRepo.save(tag);
    }

    @Override
    public void update(Tag tag) {
        tagRepo.saveAndFlush(tag);
    }

    @Override
    public void delete(Tag tag) {
        tagRepo.delete(tag);
    }

    @Override
    public Tag findByName(String name) {
        return tagRepo.findOneByName(name);
    }


}
