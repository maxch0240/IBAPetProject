package com.example.demo.subject;

import com.example.demo.student.Student;
import com.example.demo.student.StudentServiceImpl;
import com.example.demo.teacher.Teacher;
import com.example.demo.teacher.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    SubjectServiceImpl subjectServiceImpl;

    StudentServiceImpl studentServiceImpl;

    TeacherServiceImpl teacherServiceImpl;

    @Autowired
    public SubjectController(StudentServiceImpl studentServiceImpl,
                             SubjectServiceImpl subjectServiceImpl,
                             TeacherServiceImpl teacherServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
        this.subjectServiceImpl = subjectServiceImpl;
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @GetMapping
    List<Subject> getSubjects() {
        return subjectServiceImpl.getSubjects();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {
        return subjectServiceImpl.createSubject(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject addStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        Subject subject = subjectServiceImpl.findById(subjectId);
        Student student = studentServiceImpl.findById(studentId);
        subject.getEnrolledStudents().add(student);
        return subjectServiceImpl.createSubject(subject);
    }

    @PutMapping("/{subjectId}/teachers/{teacherId}")
    Subject assignTeacherToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId
    ) {
        Subject subject = subjectServiceImpl.findById(subjectId);
        Teacher teacher = teacherServiceImpl.findById(teacherId);
        subject.setTeacher(teacher);
        return subjectServiceImpl.createSubject(subject);
    }
}