package com.example.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("create-view")
    public String createView() {
        return "create.html";
    }

    @PostMapping("create")
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("email")
            String email
    ) {
        service.createStudent(name, email);
        // POST - redirect - GET
        return "redirect:/home";

        // Double Post Problem!!!
        // return "create.html";
    }

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute(
                "studentList",
                service.readAllStudents()
        );
        return "home.html";
    }

    // http://127.0.0.1:8080/1
    // http://127.0.0.1:8080/2
    // http://127.0.0.1:8080/"3" => Long id
    // 경로 변수
    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        StudentDto dto = service.readStudent(id);
        model.addAttribute("student", dto);
        return "read.html";
    }

    // http://127.0.0.1/1/update-view
    // http://127.0.0.1/2/update-view
    // http://127.0.0.1/3/update-view
    // http://127.0.0.1/4/update-view
    @GetMapping("{id}/update-view")
    public String updateView(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        StudentDto dto = service.readStudent(id);
        model.addAttribute("student", dto);
        return "update.html";
    }

    // http://127.0.0.1/1/update
    // http://127.0.0.1/2/update
    // http://127.0.0.1/3/update
    @PostMapping("{id}/update")
    public String update(
            @PathVariable("id")
            Long id,
            @RequestParam("name")
            String name,
            @RequestParam("email")
            String email
    ) {
        service.updateStudent(id, name, email);
        // POST - redirect - GET
        return String.format("redirect:/%s", id);
    }

    @GetMapping("{id}/delete-view")
    public String deleteView(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        StudentDto dto = service.readStudent(id);
        model.addAttribute("student", dto);
        return "delete.html";
    }

    @PostMapping("{id}/delete")
    public String delete(
            @PathVariable("id")
            Long id
    ) {
        service.deleteStudent(id);
        return "redirect:/home";
    }
}
