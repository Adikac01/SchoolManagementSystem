package com.example.school.Database.Grade;

import com.example.school.Database.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;
    private final String type = "grade";

    @GetMapping("/all")
    public @ResponseBody Iterable<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public @ResponseBody Grade getGradeById(@PathVariable Integer id){
        return gradeRepository.findById(id)
                .orElseThrow(()->new ObjectNotFoundException(id,type));
    }
}
