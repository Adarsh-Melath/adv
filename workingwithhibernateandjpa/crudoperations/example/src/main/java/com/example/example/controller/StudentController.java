package com.example.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.example.entity.Student;
import com.example.example.service.StudentService;

@RestController
public class StudentController {

  StudentService studentService;

  StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping("/add")
  public void addStudent(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  @GetMapping("/get/{id}")
  public Student getStudent(@PathVariable Long id) {
    return studentService.getStudentByRollNo(id);
  }

  @GetMapping("/getall")
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  @PutMapping("/change/{id}")
  public void updateStudentDetails(@PathVariable Long id, @RequestBody Student student) {
    studentService.updateStudentDetails(id, student);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
  }
}
