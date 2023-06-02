package com.example.school.Database.Grade;

import com.example.school.Database.Student.Student;
import com.example.school.Database.Subject.Subject;
import com.example.school.Database.Teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    private LocalDate date;
    private Long weight;
    @Column(name = "description")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "teacherID")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "studentID")
    private Student student;

    public Grade(String value, LocalDate date, Long weight, String desc) {
        this.value = value;
        this.date = date;
        this.weight = weight;
        this.desc = desc;
    }

    public Grade() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("student")
    public String getStudentName(){
        return student.getName();
    }

    @JsonProperty("teacher")
    public String getTeacherName(){
        return teacher.getName();
    }

    @JsonProperty("subject")
    public String getSubjectName(){
        return teacher.getSubjectName();
    }
}
