package io.pragra.lms.lmsdemo.rest;

import io.pragra.lms.lmsdemo.entitiy.Course;
import io.pragra.lms.lmsdemo.exception.CourseNotFoundException;
import io.pragra.lms.lmsdemo.service.CourseService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@RequestMapping("/api")
public class CourseRestController {
    private final CourseService courseService;

    /**
     * This will return all courses
     */


    @GetMapping("/course")
    public ResponseEntity<List<Course>> getAllCourse() {
        return ResponseEntity.ok().body(courseService.getAllCourse());
    }
}
