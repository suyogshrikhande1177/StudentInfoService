package com.atdev.service_by_suyog.controllers;

import com.atdev.service_by_suyog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/file")
public class FileCrudController {
    @Autowired
    StudentService studentService;


    @PostMapping("/createfile")
    @CrossOrigin
    public ResponseEntity<InputStreamResource> createfile() throws Exception {
        ByteArrayInputStream result;
        try {
            result= studentService.createStudentFile();
        } catch (Exception e) {
            throw new RuntimeException("Error while Creating Report");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=students.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(result));
    }

    @GetMapping("/readFile")
    @CrossOrigin
    public ResponseEntity<?> readFile(@RequestParam("file") MultipartFile file){

        studentService.readFile(file);
        return new  ResponseEntity<>("",HttpStatus.OK);
    }

}
