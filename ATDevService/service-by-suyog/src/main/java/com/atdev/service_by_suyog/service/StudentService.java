package com.atdev.service_by_suyog.service;

import com.atdev.service_by_suyog.payload.request.StudentRequest;
import com.atdev.service_by_suyog.payload.response.StudentResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    public String saveStudent(StudentRequest studentRequest);

    public String saveAllStudent(List<StudentRequest> studentRequest);

    public StudentResponse updateStudent(StudentRequest studentRequest, Long studentId);

    public String deleteByIdStudent(Long id);

    public String deleteAllByStudent(List<Long> id);

    public StudentResponse getStudent(Long id);

    public List<StudentResponse> getAllStudent();

    public ByteArrayInputStream createStudentFile();

    public List<StudentResponse> readFile(MultipartFile file);
}
