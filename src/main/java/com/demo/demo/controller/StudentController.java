package com.demo.demo.controller;

import com.demo.demo.Response;
import com.demo.demo.dto.StudentDto;
import com.demo.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired

    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Response<StudentDto> getStudentById(@PathVariable long id){
        return Response.newSuccess(studentService.getStudentById(id));
    }


    @GetMapping("/student")
    public Response<List<StudentDto>> getStudentByAge(@RequestParam int maxAge, @RequestParam int minAge) {
        return Response.newSuccess(studentService.getStudentByAges(maxAge,minAge));
    }



//    新增
    @PostMapping("/student")
    public Response<Long> newStudent(@RequestBody StudentDto studentDto){
        return Response.newSuccess(studentService.addNewStudent(studentDto));
    }

//    删除
    @DeleteMapping("/student/{id}")
    public void deleStudentById(@PathVariable long id){
        studentService.deleStudentById(id);
    }

//    更改
    @PutMapping("/student/{id}")
    public Response<StudentDto> updateStudentById(@PathVariable long id,@RequestParam(required = false) String name,@RequestParam(required = false) String email,@RequestParam(required = false) int age){
        return Response.newSuccess(studentService.updateStudentById(id,name,email,age));

    }


}
