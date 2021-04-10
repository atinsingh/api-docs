package io.pragra.lms.lmsdemo.mapper;

import io.pragra.lms.lmsdemo.entitiy.Student;
import io.pragra.lms.lmsdemo.models.StudentModel;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Data
public class StudentMapper {
    private final CourseMapper courseMapper;
    public Student mapToStudent(StudentModel model) {
        return Student.builder()
                .firstName(model.getFirstname())
                .lastName(model.getLastName())
                .courses(model.getCourses().stream().map(courseMapper::mapToCourse).collect(Collectors.toList()))
                .build();
    }

    public StudentModel mapToStudentModel(Student student) {
        StudentModel model = new StudentModel();
        model.setFirstname(student.getFirstName());
        model.setLastName(student.getLastName());
        model.setCourses(student.getCourses().stream().map(courseMapper::maptoCourseModel).collect(Collectors.toList()));

        model.setId(student.getId());
        return model;
    }
}
