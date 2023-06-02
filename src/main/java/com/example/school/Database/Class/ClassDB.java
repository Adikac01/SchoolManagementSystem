package com.example.school.Database.Class;

import com.example.school.Database.Student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classes")
public class ClassDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year;
    @Column(name = "short_name")
    private String className;
    private String profile;

    @OneToMany(mappedBy = "classDB")
    private List<Student> studentList;

    public ClassDB(String year, String className, String profile) {
        this.year = year;
        this.className = className;
        this.profile = profile;
    }

    public ClassDB() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getClassName() {
        return className;
    }

    public void setShortName(String className) {
        this.className = className;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonIgnore
    public List<Student> getStudentList(){
        return this.studentList;
    }
}
