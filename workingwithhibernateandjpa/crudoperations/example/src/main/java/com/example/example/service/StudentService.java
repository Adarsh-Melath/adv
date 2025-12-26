package com.example.example.service;

import java.util.List;

import com.example.example.entity.Student;

public interface StudentService {

  void addStudent(Student student);

  Student getStudentByRollNo(Long rollNo);

  List<Student> getAllStudents();

  void updateStudentDetails(Long rollno, Student student);

  void deleteStudent(Long rollNo);
}
