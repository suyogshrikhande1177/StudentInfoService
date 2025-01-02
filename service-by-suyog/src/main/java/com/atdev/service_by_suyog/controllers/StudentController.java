package com.atdev.service_by_suyog.controllers;

import com.atdev.service_by_suyog.payload.request.StudentRequest;
import com.atdev.service_by_suyog.payload.response.StudentResponse;
import com.atdev.service_by_suyog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.saveStudent(studentRequest), HttpStatus.OK);
    }

    @PostMapping("/createAll")
    public ResponseEntity<?> saveAllStudent(@RequestBody final List<StudentRequest> studentRequest){
        return new ResponseEntity<>(studentService.saveAllStudent(studentRequest), HttpStatus.OK);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody final StudentRequest studentRequest, @PathVariable("studentId") Long studentId){
        return new ResponseEntity<>(studentService.updateStudent(studentRequest,studentId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") final Long id){
        return new ResponseEntity<>(studentService.deleteByIdStudent(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAllStudent(@RequestBody final List<Long> id){
        return new ResponseEntity<>(studentService.deleteAllByStudent(id), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable final Long id){
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllStudent(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }












}
