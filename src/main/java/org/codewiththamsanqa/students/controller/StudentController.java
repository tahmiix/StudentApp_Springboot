package org.codewiththamsanqa.students.controller;

import org.codewiththamsanqa.students.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    public final List<Student> studentList = List.of(
            new Student("Thamsanqa",1,"Skenjana","tahmiix@gamil.com","Programming")
    );

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.studentList;
    }

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable int id){
        return studentList.get(id);
    }
}
