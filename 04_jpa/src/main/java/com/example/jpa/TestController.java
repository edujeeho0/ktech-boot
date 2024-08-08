package com.example.jpa;

import com.example.jpa.model.Instructor;
import com.example.jpa.model.Student;
import com.example.jpa.repo.InstructorRepository;
import com.example.jpa.repo.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {
    private final StudentRepository repository;
    private final InstructorRepository instructorRepository;
    public TestController(
            StudentRepository repository,
            InstructorRepository instructorRepository
    ) {
        this.repository = repository;
        this.instructorRepository = instructorRepository;
    }

    // /test
    // http://localhost:8080/test
    @GetMapping("test")
    public String test() {
//        // CREATE
//        Student newStudent = new Student();
//        newStudent.setName("Alex");
//        newStudent.setEmail("alex@gmail.com");
//        System.out.println(newStudent.getId());  // null
//        Student saved = repository.save(newStudent);
//        System.out.println(saved.getId());
//        System.out.println(saved);
//
//        // READ
//        Student readOne = repository.findById(1L)
//                .orElse(null);
//        System.out.println(readOne);
//        List<Student> readAll = repository.findAll();
//        System.out.println(readAll.size());
//
//        // UPDATE
//        Student target = repository.findById(1L)
//                .orElseThrow();
//        target.setAge(readAll.size());
//        repository.save(target);
//
//        // DELETE
//        repository.deleteById(2L);
//        repository.delete(saved);

//        System.out.println(repository.findAllByEmailEndingWith("hotmail.org"));

        List<Student> results = repository.findAllByAdvisorId(3L);
        for (Student result: results) {
            System.out.print(result.getName() + " ");
        }
        System.out.println();

        Instructor advisor = instructorRepository
                .findById(3L)
                .orElseThrow();
        results = repository.findAllByAdvisor(advisor);
        for (Student result: results) {
            System.out.print(result.getName() + " ");
        }
        System.out.println();

        results = repository.findAllByAdvisorLastName("Best");
        for (Student result: results) {
            System.out.print(result.getName() + " ");
        }
        System.out.println();

        return "test.html";
    }
}
