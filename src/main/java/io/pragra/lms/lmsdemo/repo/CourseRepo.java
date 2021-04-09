package io.pragra.lms.lmsdemo.repo;

import io.pragra.lms.lmsdemo.entitiy.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
}