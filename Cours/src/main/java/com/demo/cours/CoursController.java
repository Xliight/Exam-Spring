package com.demo.cours;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Cours")
@RequiredArgsConstructor
public class CoursController {

    private final CourslService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Cours cours ) {
        service.saveCours(cours);
    }

    @GetMapping
    public ResponseEntity<List<Cours>> findAllCours() {
        return ResponseEntity.ok(service.findAllCours());
    }


    @GetMapping("/{courseId}/students")
    public ResponseEntity<List<Student>> getAllStudentsForCourse(@PathVariable Long courseId) {
        List<Student> students = service.getAllStudentsForCourse(courseId);
        return ResponseEntity.ok(students);
    }
}
