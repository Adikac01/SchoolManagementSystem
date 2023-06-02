package com.example.school.Database.Subject;

import com.example.school.Database.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;
    private final String type = "subject";

    @GetMapping("/all")
    public @ResponseBody Iterable<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
    @GetMapping("/id/{id}")
    public @ResponseBody Subject getSubjectById(@PathVariable String id){
        Integer subjectId = Integer.parseInt(id);
        return subjectRepository.findById(subjectId)
                .orElseThrow(()->new ObjectNotFoundException(subjectId, this.type));
    }
}
