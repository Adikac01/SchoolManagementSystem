package com.example.school.Database.Class;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ClassRepository extends CrudRepository<ClassDB, Integer> {
    @Query("SELECT * FROM students JOIN classes ON students.classID = classes.ID WHERE classes.short_name = :className")
    ClassDB findStudentsByClassName(@Param("className") String className);

    List<ClassDB> findByClassName(String shortName);


}
