package com.example.absencespring.controller;

import com.example.absencespring.model.BoundedPageSize;
import com.example.absencespring.model.PageFromOne;
import com.example.absencespring.model.Presence;
import com.example.absencespring.model.Users;
import com.example.absencespring.service.PresenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PresenceController {
    private final PresenceService presenceService;

    @GetMapping(value = "/presences/students/{id}")
    public Presence getPresenceByStudentId(
            @PathVariable int id,
            @RequestParam PageFromOne page,
            @RequestParam("page_size") BoundedPageSize pageSize) {
        return presenceService.getByStudentId(id, page, pageSize);
    }

    @GetMapping(value = "/presences/group")
    public List<Presence> getPresenceByGroup(
            @RequestParam PageFromOne page, @RequestParam("page_size") BoundedPageSize pageSize,
            @RequestParam(value = "group_name", required = false, defaultValue = "") String groupName) {
        return presenceService.getByGroup(groupName, page, pageSize);
    }
    @GetMapping(value = "/students/presence")
    public List<Presence> getPresences() {
        return presenceService.getPresences()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    @PostMapping(value = "/teachers/{id}/presences")
    public Presence postPresence(@PathVariable int id,
                                 @RequestBody Presence newPresence){
        return presenceService.newPresence(id, newPresence);
    }
    @PutMapping(value = "/presences/group")
    public Presence updatePresence(@RequestBody Presence presence) {
        return presenceService.save(presence);
    }
}