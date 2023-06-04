package com.example.school.Database.Teacher;

import com.example.school.Database.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    private final String type = "teacher";

    @GetMapping("/all")
    public @ResponseBody Iterable<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public @ResponseBody Teacher getTeacherById(@PathVariable String id){
        Integer teacherID = Integer.parseInt(id);
        return teacherRepository.findById(teacherID)
                .orElseThrow(() -> new ObjectNotFoundException(teacherID, type));
    }

    @GetMapping("/name/{name}")
    public @ResponseBody Iterable<Teacher> getTeacherByName(@PathVariable String name){
        String[] fullName = name.split(" ");
        return teacherRepository.findByFirstNameAndLastName(fullName[0], fullName[1]);
    }

    @GetMapping("/subject/{name}")
    public @ResponseBody String getSubjectOfTeacherByName(@PathVariable String name){
        String[] fullName = name.split(" ");
        List<Teacher> teachers = teacherRepository.findByFirstNameAndLastName(fullName[0], fullName[1]);
        StringBuilder res = new StringBuilder();
        for (Teacher teacher: teachers){
            res.append(teacher.getName()).append(" teaches ").append(teacher.getSubjectName());
        }
        return res.toString();
    }
}
