package com.example.school.Database.Class;

import com.example.school.Database.ObjectNotFoundException;
import com.example.school.Database.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/classes")
public class ClassController {
    @Autowired
    private ClassRepository classRepository;
    private final String type = "class";

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<ClassDB> getAllClasses(){
        return classRepository.findAll();
    }
    @GetMapping(path = "/id/{id}")
    public @ResponseBody ClassDB getClassByID(@PathVariable String id){
        int classID = Integer.parseInt(id);
        return classRepository.findById(classID)
                .orElseThrow(() -> new ObjectNotFoundException(classID, type));
    }
    @GetMapping(path = "/studentsOf/{id}")
    public @ResponseBody Iterable<Student> getStudentsOfClass(@PathVariable Integer id) {
//        ClassDB classDB =  classRepository.findStudentsByClassName(className);
//        return classDB.getStudentList();
        ClassDB classDB = classRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, type));
        return classDB.getStudentList();
    }
}
