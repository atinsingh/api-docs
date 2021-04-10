package io.pragra.lms.lmsdemo;

import io.pragra.lms.lmsdemo.entitiy.Course;
import io.pragra.lms.lmsdemo.service.CourseService;
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

    public static void main(String[] args) {
        SpringApplication.run(LmsDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
          service.createCourse(
                  Course.builder()
                          .courseName("JAVA")
                          .courseDescription("Awesome Java Program, learn from novice to Ninja")
                          .uuid(UUID.randomUUID().toString())
                          .imageName("java.jpeg")
                          .build());

          service.createCourse(Course.builder()
                  .courseName("DevOps")
                  .courseDescription("All Good course")
                  .uuid(UUID.randomUUID().toString())
                  .imageName("devops.jpeg")
                  .build());
          service.createCourse(Course.builder()
                  .courseName("Automation")
                  .uuid(UUID.randomUUID().toString())
                  .imageName("automation.jpeg")
                  .build());
        };
    }

}
