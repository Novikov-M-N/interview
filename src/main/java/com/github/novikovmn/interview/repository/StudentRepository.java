package com.github.novikovmn.interview.repository;

import com.github.novikovmn.interview.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();
}
