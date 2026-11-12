package org.codewiththamsanqa.students.controller;

import org.codewiththamsanqa.students.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    public final List<Student> studentList = List.of(
            new Student(1,"Thamsanqa","Skenjana","tahmiix@gamil.com","Programming"),
            new Student(2,"Gift","Skenjana","gift@gmail.com","Programming"),
            new Student(3,"Thami","Jack","Jack@gmail.com","Programming"),
            new Student(4,"john","doe","jdoe@gmail.com","Programming")
    );

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.studentList;
    }

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable int id){
        return studentList.stream()
                            .filter(student -> student.id() == id)
                            .findFirst()
                            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"));
    }
}
