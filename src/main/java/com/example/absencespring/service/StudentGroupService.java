package com.example.absencespring.service;

import com.example.absencespring.model.StudentGroup;
import com.example.absencespring.repository.StudentGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentGroupService {
    private final StudentGroupRepository studentGroupRepository;

    public List<StudentGroup> getStudentGroup() {return studentGroupRepository.findAll();}


}
