package io.pragra.lms.lmsdemo.mapper;

import io.pragra.lms.lmsdemo.entitiy.Course;
import io.pragra.lms.lmsdemo.models.CourseModel;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public Course mapToCourse(CourseModel model) {
        return Course.builder()
                .courseName(model.getName())
                .courseDescription(model.getDescription())
                .uuid(model.getUuid())
                .build();
    }

    public CourseModel maptoCourseModel(Course course) {
        CourseModel model = new CourseModel();
        model.setDescription(course.getCourseDescription());
        model.setId(course.getId());
        model.setName(course.getCourseName());
        model.uuid(course.getUuid());
        return model;
    }
}
