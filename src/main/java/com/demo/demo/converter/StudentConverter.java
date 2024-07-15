package com.demo.demo.converter;

import com.demo.demo.dao.student;
import com.demo.demo.dto.StudentDto;

public class StudentConverter {

    public static StudentDto converterStudent(student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setAge(student.getAge());
        return studentDto;

    }

    public static student converterStudentDto(StudentDto studentDto){
        student student = new student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        return student;

    }
}
