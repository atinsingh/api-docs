package io.pragra.lms.lmsdemo.controller;

import io.pragra.lms.lmsdemo.entitiy.Course;
import io.pragra.lms.lmsdemo.entitiy.Student;
import io.pragra.lms.lmsdemo.service.CourseService;
import io.pragra.lms.lmsdemo.service.StudentService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@Data
public class HomeController {

    private final CourseService service;
    private final StudentService studentService;

    @GetMapping("/")
    public String home(Model model) {
        List<Course> course = service.getAllCourse().stream().collect(Collectors.toList());
        List<Student> student = studentService.getAllStudents().stream().collect(Collectors.toList());
            model.addAttribute("course", course.get(0));
            model.addAttribute("course1",course.get(1));
            model.addAttribute("course2", course.get(2));
            model.addAttribute("student1",student.get(0));



        return "index";
    }

//    @GetMapping("/student")
//    public String Student(Model model){
//
//        return "index";
//    }
}
