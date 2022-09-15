package com.example.absencespring.service;

import com.example.absencespring.model.Courses;
import com.example.absencespring.repository.CoursesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
        private final CoursesRepository courseRepository;

        public Courses getCourseById(String courseId) {return courseRepository.getById(courseId);}

        public List<Courses> getCourses() {return courseRepository.findAll();}

        public List<Courses> saveAll(List<Courses> courses) {return courseRepository.saveAll(courses);}
}


