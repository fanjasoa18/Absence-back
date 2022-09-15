package com.example.absencespring.service;

import com.example.absencespring.model.BoundedPageSize;
import com.example.absencespring.model.PageFromOne;
import com.example.absencespring.model.Presence;
import com.example.absencespring.model.Users;
import com.example.absencespring.repository.PresenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Service
@AllArgsConstructor
public class PresenceService extends Presence{
    private final PresenceRepository presenceRepository;

    public List<Presence> getPresences() {return presenceRepository.findAll();}

    public Presence save(
            Presence presence) {
        return presenceRepository.save(presence);
    }

    public Presence getByStudentId(int id, PageFromOne page, BoundedPageSize pageSize) {
        return presenceRepository.getByStudentId(id);
    }

    public List<Presence> getByGroup(
            String groupName,
            PageFromOne page, BoundedPageSize pageSize) {
        Pageable pageable = PageRequest.of(
                page.getValue() - 1,
                pageSize.getValue(),
                Sort.by(ASC, "ref"));
        return presenceRepository
                .findByGroupName(groupName, pageable);
    }

    public Presence newPresence(int id, Presence presenceToCreate){
        return presenceRepository.save(presenceToCreate);
    }
}
