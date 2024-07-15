package com.demo.demo.service;


import com.demo.demo.converter.StudentConverter;
import com.demo.demo.dao.StudentRepository;
import com.demo.demo.dao.student;
import com.demo.demo.dto.StudentDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto getStudentById(long id) {
        student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.converterStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDto studentDto) {
        List<student> studentList = studentRepository.findByEmail(studentDto.getEmail());
        if (!CollectionUtils.isEmpty(studentList)){
            throw new IllegalStateException("email:" + studentDto.getEmail() + "has been taken");
        }
        student student = studentRepository.save(StudentConverter.converterStudentDto(studentDto));
        return student.getId();
    }

    @Override
    public void deleStudentById(long id) {
        studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id" + id + "doesn't exit"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDto updateStudentById(long id, String name, String email,int age) {
        student studentInDB = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id" + id + "doesn't exit"));
        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)){
            studentInDB.setName(name);
        }
        if (StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)) {
            studentInDB.setEmail(email);
        }
        if (age != 0 && studentInDB.getAge() != age) {
            studentInDB.setAge(age);
        }
        student student = studentRepository.save(studentInDB);
        return StudentConverter.converterStudent(student);
    }

    @Override
    public List<StudentDto> getStudentByAges(int maxAge, int minAge) {
        List<student> studentList = studentRepository.findByAgeBetween(minAge,maxAge);
        if (CollectionUtils.isEmpty(studentList)) {
            return List.of();
        }
        return studentList.stream().map(StudentConverter::converterStudent).collect(Collectors.toList());
    }


}
