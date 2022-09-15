package com.example.absencespring.controller;


import com.example.absencespring.model.Courses;
import com.example.absencespring.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static java.util.stream.Collectors.toUnmodifiableList;

@RestController
@AllArgsConstructor
public class CoursesController {
    private final CourseService courseService;

    @GetMapping(value = "/courses/{id}")
    public Courses getCoursesById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @GetMapping(value = "/courses")
    public List<Courses> getCourses() {
        return courseService.getCourses().stream()
                .collect(toUnmodifiableList());
    }

    @PutMapping(value = "/courses")
    public List<Courses> createOrUpdateCourses(@RequestBody List<Courses> toWrite) {
        var saved = courseService.saveAll(toWrite.stream()
                .collect(toUnmodifiableList()));
        return saved.stream()
                .collect(toUnmodifiableList());
    }
}
