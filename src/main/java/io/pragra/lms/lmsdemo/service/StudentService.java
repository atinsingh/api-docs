package io.pragra.lms.lmsdemo.service;

import io.pragra.lms.lmsdemo.entitiy.Student;
import io.pragra.lms.lmsdemo.mapper.StudentMapper;
import io.pragra.lms.lmsdemo.models.StudentModel;
import io.pragra.lms.lmsdemo.repo.StudentRepo;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class StudentService {
    private final StudentRepo repo;
    private final StudentMapper mapper;

    public StudentModel createStudent(StudentModel studentModel) {
        if(studentModel.getFirstname()==null || studentModel.getFirstname().isEmpty()) {
            throw new RuntimeException("Student Can't be created with null values");
        }
        Student student = mapper.mapToStudent(studentModel);
        return mapper.mapToStudentModel(repo.save(student));
    }


    public List<StudentModel> getAllStudent() {
        return
                repo.findAll().stream().map(mapper::mapToStudentModel).collect(Collectors.toList());
    }

    public StudentModel getStudentById(Long studentId) {
        return repo.findById(studentId).map(mapper::mapToStudentModel).orElseThrow(RuntimeException::new);
    }
}
