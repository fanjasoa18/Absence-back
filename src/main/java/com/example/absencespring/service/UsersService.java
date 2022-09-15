package com.example.absencespring.service;

import com.example.absencespring.model.Users;
import com.example.absencespring.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository userRepository;

    public Optional<Users> getById(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public List<Users> saveAll(List<Users> users) {
        return userRepository.saveAll(users);
    }
}
