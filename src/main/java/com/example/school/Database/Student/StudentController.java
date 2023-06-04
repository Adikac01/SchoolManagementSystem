package com.example.school.Database.Student;

import com.example.school.Database.Grade.Grade;
import com.example.school.Database.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    private final String type = "Student";

    @GetMapping("/all")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public @ResponseBody Student getStudentById(@PathVariable String id){
        Integer studentID = Integer.parseInt(id);
        return studentRepository.findById(studentID)
                .orElseThrow(() -> new ObjectNotFoundException(studentID, type));
    }
    @GetMapping("/name/{name}")
    public @ResponseBody Iterable<Student> getStudentByName(@PathVariable String name){
        String[] fullName =  name.split(" ");
        return   studentRepository.findByFirstNameAndLastName(fullName[0],fullName[1]);
    }

    @GetMapping("/grades/{id}")
    public @ResponseBody Iterable<Grade> getGradesByName(@PathVariable Integer id){
        Student stud = studentRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id,type));
        return stud.getGradeList();
    }
}
