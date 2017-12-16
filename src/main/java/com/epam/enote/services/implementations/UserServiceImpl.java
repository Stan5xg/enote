package com.epam.enote.services.implementations;

import com.epam.enote.entities.User;
import com.epam.enote.repos.UserRepo;
import com.epam.enote.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public void create(User user) {
        userRepo.save(user);
    }

    @Override
    public void update(User user) {
        if (userRepo.existsById(user.getId())) {
            userRepo.saveAndFlush(user);
        }
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User getByName(String username) {
        return userRepo.findOneByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
