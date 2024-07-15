package com.demo.demo.service;

import com.demo.demo.dao.student;
import com.demo.demo.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto getStudentById(long id);

    Long addNewStudent(StudentDto studentDto);

    void deleStudentById(long id);


    StudentDto updateStudentById(long id, String name, String email ,int age);

    List<StudentDto> getStudentByAges(int maxAge, int minAge);
}
