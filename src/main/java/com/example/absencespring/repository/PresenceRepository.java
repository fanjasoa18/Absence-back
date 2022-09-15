package com.example.absencespring.repository;

import com.example.absencespring.model.Presence;
import com.example.absencespring.model.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresenceRepository extends JpaRepository<Presence, Integer> {
    Presence getByStudentId(int id);

    List<Presence> findByGroupName(String groupName, Pageable pageable);
   /* Presence getByStudentId(int id);

    List<Presence> findByGroupName(
            String groupName, Pageable pageable);
    Presence saveStatus(String groupName, String status);*/
}
