package io.pragra.lms.lmsdemo;

import io.pragra.lms.lmsdemo.entitiy.Course;
import io.pragra.lms.lmsdemo.entitiy.Student;
import io.pragra.lms.lmsdemo.service.CourseService;
import io.pragra.lms.lmsdemo.service.StudentService;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class LmsDemoApplication {

    @Autowired
    private CourseService service;
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(LmsDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
          service.createCourse(Course.builder().courseName("JAVA12345").uuid(UUID.randomUUID().toString()).build());
          service.createCourse(Course.builder().courseName("DevOps").uuid(UUID.randomUUID().toString()).build());
          service.createCourse(Course.builder().courseName("Automation").uuid(UUID.randomUUID().toString()).build());

          studentService.createStudent(Student.builder().id(1).firstName("Prakash").lastName("Makhijani").build());


        };
    }

}
