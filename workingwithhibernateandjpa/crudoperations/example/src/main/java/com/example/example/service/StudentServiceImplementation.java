package com.example.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.example.entity.Student;
import com.example.example.repository.StudentRepo;

@Service
public class StudentServiceImplementation implements StudentService {

  StudentRepo studentRepo;

  StudentServiceImplementation(StudentRepo studentRepo) {
    this.studentRepo = studentRepo;
  }

  @Override
  public void addStudent(Student student) {
    studentRepo.save(student);
  }

  @Override
  public Student getStudentByRollNo(Long rollNo) {
    Student student = studentRepo.findById(rollNo).get();
    return student;
  }

  @Override
  public List<Student> getAllStudents() {
    List<Student> students = studentRepo.findAll();
    return students;
  }

  @Override
  public void updateStudentDetails(Long id, Student student) {
    Student student1 = studentRepo.findById(id).get();
    student1.setName(student.getName());
    student1.setEmail(student.getEmail());
    student1.setAge(student.getAge());
    studentRepo.save(student1);
  }

  @Override
  public void deleteStudent(Long rollNo) {
    Student student = studentRepo.findById(rollNo).get();
    studentRepo.delete(student);
  }

}
