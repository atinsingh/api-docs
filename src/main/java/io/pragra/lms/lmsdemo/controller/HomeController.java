package io.pragra.lms.lmsdemo.controller;

import io.pragra.lms.lmsdemo.entitiy.Course;
import io.pragra.lms.lmsdemo.service.CourseService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
@Data
public class HomeController {

    private final CourseService service;

    @GetMapping("/")
    public String home(Model model) {
        Optional<Course> course = service.getAllCourse().stream().findAny();
        if(course.isPresent()) {
            model.addAttribute("course", course.get());
        }
        return "index";
    }
}
