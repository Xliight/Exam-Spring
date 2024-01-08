package com.demo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public List<Student> findAllStudentsByCours(Integer schoolId) {
        return repository.findAllByCoursId(coursId);
    }

     public Student getStudentById(Long studentId) {
        return new Student(studentId, "John Doe");
    }
}
