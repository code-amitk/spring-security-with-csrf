package com.amit.security.controller;

import com.amit.security.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(1, "amit", 10),
            new Student(2, "akshay", 20),
            new Student(3, "sandy", 30)
    ));

   @RequestMapping
   List<Student> getStudents() {
       return studentList;
    }

   @PostMapping
   List<Student> addStudent(@RequestBody Student student) {
       studentList.add(student);
       return studentList;
    }
}
