package com.example.jpa;

import com.example.jpa.model.Instructor;
import com.example.jpa.model.Student;
import com.example.jpa.repo.InstructorRepository;
import com.example.jpa.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final InstructorRepository instructorRepository;
    public StudentService(
            StudentRepository repository,
            InstructorRepository instructorRepository
    ) {
        this.repository = repository;
        this.instructorRepository = instructorRepository;
    }

    // CREATE
    public Student create(
            String name,
            Integer age,
            String phone,
            String email,
            Long advisorId
    ) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);
        student.setEmail(email);
        // 교수님을 찾는다.
        Optional<Instructor> instructorOpt = instructorRepository.findById(advisorId);
        // 새로 생성한 학생에, save 하기 전에 advisor를 넣어준다.
        student.setAdvisor(instructorOpt.orElse(null));
//        student.setAdvisor(instructorRepository.findById(advisorId).orElse(null));
        return repository.save(student);
    }

    // READ
    public List<Student> readAll() {
        return repository.findAll();
    }

    public Student readOne(Long id) {
        Optional<Student> student = repository.findById(id);
        return student.orElse(null);
    }
}
