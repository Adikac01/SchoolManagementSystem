package com.example.school.Database.Student;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {


    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
}
