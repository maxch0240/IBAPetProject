package com.example.demo.teacher;

import com.example.demo.student.Student;
import com.example.demo.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Subject> subjects;

    @JsonIgnore
    @OneToMany(mappedBy = "headTeacher", cascade = CascadeType.ALL)
    private Set<Student> students;
}
