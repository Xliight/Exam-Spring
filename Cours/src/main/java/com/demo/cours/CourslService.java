package com.demo.cours;

import com.demo.cours.client.StudentClient;
import com.demo.student.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourslService {

    private final CoursRepository repository;
    private final StudentService studentService;
    private final StudentClient client;

    public void saveCours(Cours cours) {
        repository.save(cours);
    }

    public List<Cours> findAllCours() {
        return repository.findAll();
    }

    public FullCoursResponse findCoursWithStudents(Integer schoolId) {
        var cours = repository.findById(schoolId)
                .orElse(
                        Cours.builder()
                                .name("NOT_FOUND")
                                .student("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsByCours(schoolId);
        return FullCoursResponse.builder()
                .name(cours.getName())
                .email(cours.getStudent())
                .students(students)
                .build();
    }
    public List<Student> getAllStudentsForCourse(Long courseId) {

        List<Student> students = new ArrayList<>();
        students.add(new Student( "John Doe","John Doe","John Doe@gg.com"));
        students.add(new Student("John Doe","John Doe","John Doe@gg.com"));
        return students;
    }

}
}
