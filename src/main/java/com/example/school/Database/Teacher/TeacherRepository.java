package com.example.school.Database.Teacher;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher,Integer> {

    List<Teacher> findByFirstNameAndLastName(String firstName, String lastName);
}
