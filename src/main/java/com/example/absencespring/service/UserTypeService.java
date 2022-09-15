package com.example.absencespring.service;

import com.example.absencespring.model.Presence;
import com.example.absencespring.model.UserType;
import com.example.absencespring.repository.UserTypeRepository;
import com.example.absencespring.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserTypeService {
    private final UserTypeRepository userTypeRepository;
    public List<UserType> getRoles() {return userTypeRepository.findAll();}
}
