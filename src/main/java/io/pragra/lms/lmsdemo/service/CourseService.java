package io.pragra.lms.lmsdemo.service;

import io.pragra.lms.lmsdemo.entitiy.Course;
import io.pragra.lms.lmsdemo.repo.CourseRepo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@Slf4j
public class CourseService {
    private final CourseRepo repo;

    public Course createCourse(Course course) {
        if(course.getUuid() == null) {
            log.error("Course name: [{}]  has uuid as null", course.getCourseName());
            throw new RuntimeException("UUID Can't be null");
        }
        return repo.save(course);
    }

    public List<Course> getAllCourse(){
        return repo.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return repo.findById(id);
    }


}
