package com.example.absencespring.repository;

import com.example.absencespring.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, String> {
}
