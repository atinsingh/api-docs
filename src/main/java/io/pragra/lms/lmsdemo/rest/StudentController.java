package io.pragra.lms.lmsdemo.rest;

import io.pragra.lms.lmsdemo.api.StudentApi;
import io.pragra.lms.lmsdemo.models.StudentModel;
import io.pragra.lms.lmsdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentApi {
    private final StudentService service;

    @Override
    public ResponseEntity<List<StudentModel>> studentGet() {
        if(service.getAllStudent().size()!=0) {
           throw new RuntimeException("No Student Available");
        }
        return ResponseEntity.ok().body(service.getAllStudent());
    }

    @Override
    public ResponseEntity<StudentModel> studentPost(@Valid StudentModel body) {
        return ResponseEntity.accepted().body(service.createStudent(body));
    }

    @Override
    public ResponseEntity<StudentModel> studentStudentIdGet(Long studentId) {
        return ResponseEntity.ok().body(service.getStudentById(studentId));
    }
}
