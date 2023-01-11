package com.example.demo.subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjects();
    Subject createSubject(Subject subject);
    Subject findById(long subjectId);
}
