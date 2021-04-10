package io.pragra.lms.lmsdemo.service;

import io.pragra.lms.lmsdemo.repo.StudentRepo;
import lombok.Data;

@Data
public class StudentService {
    private final StudentRepo repo;
}
