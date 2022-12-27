package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student>theStudents;

    //  define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Jakup","Sinani"));
        theStudents.add(new Student("Veton","Ismaili"));
        theStudents.add(new Student("Rilind","Limani"));
    }

    //  define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student>getStudents(){
        return theStudents;
    }

    //  define endpoint for "/students/{studentId} - return a student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //  just index into the list ...
        return theStudents.get(studentId);
    }

}