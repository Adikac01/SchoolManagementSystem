package com.example.school.Database.Teacher;

import com.example.school.Database.Grade.Grade;
import com.example.school.Database.Subject.Subject;
import com.example.school.Database.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "userID")
    private User user;

    @OneToOne
    @JoinColumn(name = "subjectID")
    private Subject subject;

    @OneToMany(mappedBy = "teacher")
    private List<Grade> grades;

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonProperty("subject")
    public String getSubjectName(){
        return subject.getName();
    }

    @JsonIgnore
    public String getName(){
        return firstName + " " + lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
