package com.example.demo.teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();
    Teacher createTeacher(Teacher teacher);
    Teacher findById(long studentId);
}
