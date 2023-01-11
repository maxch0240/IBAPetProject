package com.example.demo.student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student createStudent(Student student);
    Student findById(long studentId);
}
