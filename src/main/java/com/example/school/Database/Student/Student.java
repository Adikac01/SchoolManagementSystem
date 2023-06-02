package com.example.school.Database.Student;


import com.example.school.Database.Class.ClassDB;
import com.example.school.Database.Grade.Grade;
import com.example.school.Database.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "classID")
    private ClassDB classDB;

    @OneToMany(mappedBy = "student")
    private List<Grade> gradeList;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("class")
    public String getClassDBName(){
        return this.classDB.getClassName();
    }

    @JsonIgnore
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    @JsonIgnore
    public List<Grade> getGradeList() {
        return this.gradeList;
    }
}
