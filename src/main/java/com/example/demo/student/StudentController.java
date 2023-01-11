package com.example.demo.student;

import com.example.demo.teacher.Teacher;
import com.example.demo.teacher.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentServiceImpl studentServiceImpl;

    TeacherServiceImpl teacherServiceImpl;

    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl, TeacherServiceImpl teacherServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @GetMapping
    List<Student> getStudents() {
        return studentServiceImpl.getStudents();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentServiceImpl.createStudent(student);
    }

    @PutMapping("/{studentId}/teachers/{teacherId}")
    Student assignStudentToTeacher(
            @PathVariable Long studentId,
            @PathVariable Long teacherId
            ) {
        Student student = studentServiceImpl.findById(studentId);
        Teacher teacher = teacherServiceImpl.findById(teacherId);
        student.setHeadTeacher(teacher);
        return studentServiceImpl.createStudent(student);
    }
}