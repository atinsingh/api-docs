package io.pragra.lms.lmsdemo.service;

import io.pragra.lms.lmsdemo.entitiy.Student;
import io.pragra.lms.lmsdemo.repo.StudentRepo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@Slf4j
public class StudentService {
    @Autowired
    private final StudentRepo studentRepo;


    public Student createStudent(Student student){
       return studentRepo.save(student);

    }

    public List<Student> getAllStudents (){
        return studentRepo.findAll();
    }
}
