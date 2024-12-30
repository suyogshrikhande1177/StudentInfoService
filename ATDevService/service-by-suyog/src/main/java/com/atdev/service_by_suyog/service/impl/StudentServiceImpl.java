package com.atdev.service_by_suyog.service.impl;

import com.atdev.service_by_suyog.mapper.StudentMapper;
import com.atdev.service_by_suyog.models.Student;
import com.atdev.service_by_suyog.payload.request.StudentRequest;
import com.atdev.service_by_suyog.payload.response.StudentResponse;
import com.atdev.service_by_suyog.repository.StudentRepository;
import com.atdev.service_by_suyog.service.StudentService;
import com.atdev.service_by_suyog.utils.ExportFile;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String saveStudent(StudentRequest studentRequest) {
        if (Objects.nonNull(studentRequest)) {
//            Student student = StudentMapper.INSTANCE.toEntity(studentRequest);
//              Student student = this.modelMapper.map(studentRequest,Student.class)
            studentRepository.save(StudentMapper.INSTANCE.toEntity(studentRequest));
        }else {
            throw new RuntimeException("got null request");
        }
        return "Student Added Successfully";
    }

    @Override
    public String saveAllStudent(List<StudentRequest> studentRequestList) {
            List<Student> allStudent = studentRequestList.stream()
                    .map(i -> StudentMapper.INSTANCE.toEntity(i))
                    .collect(Collectors.toList());
            if(!allStudent.isEmpty()) {
                studentRepository.saveAll(allStudent);
            }else {
                throw new RuntimeException("Some think went Wrong in Student List of data");
            }
        return "Student List Added Successfully";
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long studentId) {
        StudentResponse studentResponse = null;
        Optional<Student> studentById = studentRepository.findById(studentId);
        if(studentById.isPresent()){
         Student student = studentById.get();
        StudentMapper.INSTANCE.update(student,studentRequest);
        student.setStudentKey(studentId);
        studentRepository.save(student);
        studentResponse = StudentMapper.INSTANCE.toResponse(student);
        }
        return studentResponse;
    }

    @Override
    public String deleteByIdStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student Successfully deleted";
    }

    @Override
    public String deleteAllByStudent(List<Long> id) {
        studentRepository.deleteAllById(id);
        return "Students Successfully deleted";
    }

    @Override
    public StudentResponse getStudent(Long id) {
        Student student = studentRepository.findById(id).get();
        return StudentMapper.INSTANCE.toResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        List<Student> allStudent = studentRepository.findAll();
        return StudentMapper.INSTANCE.toResponseList(allStudent);
    }

    //Use Like this method instated of mapStruct or ModelMapper
    private static Student requestToEntity(StudentRequest studentRequest){
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setMiddleName(studentRequest.getMiddleName());
        student.setLastName(studentRequest.getLastName());
        student.setMotherName(studentRequest.getMotherName());
        student.setAddress(studentRequest.getAddress());
        student.setDob(studentRequest.getDob());
        student.setGender(studentRequest.getGender());
        student.setMobileNum(studentRequest.getMobileNum());
        student.setTaluka(studentRequest.getTaluka());
        student.setDistrict(studentRequest.getDistrict());
        student.setHandicapped(studentRequest.getHandicapped());
        student.setQualification(studentRequest.getQualification());
        student.setDtOfAdmsn(studentRequest.getDtOfAdmsn());
       return student;
    }

    @Override
    public ByteArrayInputStream createStudentFile(){
        ByteArrayInputStream byteArrayInputStream = null;

        try{
            List<Student> students  = studentRepository.findAll();
            String headers = "Sr.No,First Name,Middle Name,Last Name,Gender,Mother Name,Qualification,Address,Mobile,Date of Birth,Date_Of_Admission,Taluka,District,Handicapped";
            ExportFile expFile = new ExportFile();
            byteArrayInputStream = expFile.createXlsFileNew(students,headers);

        }catch (Exception e){
            e.getMessage();
        }

        return byteArrayInputStream;
    }

    @Override
    public List<StudentResponse> readFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        ByteArrayInputStream byteArrayInputStream = null;
        String message = "";

        if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
            Map<String, Integer> headers = new HashMap<>();
            try {
                XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
                XSSFSheet worksheet = workbook.getSheetAt(0);
                DataFormatter formatter = new DataFormatter();
                int count = worksheet.getPhysicalNumberOfRows();
                if (count>=2){
                    XSSFRow headerRow = worksheet.getRow(0);
                    headers = IntStream.range(0, headerRow.getPhysicalNumberOfCells())
                                    .boxed()
                                    .collect(Collectors.toMap(
                                            i -> headerRow.getCell(i).getStringCellValue(),
                                            i -> i ));
                    List<StudentResponse> studentResponseList = new ArrayList<>();
                    Map<String,String> errorList = new HashMap<>();
                    if (headers != null && !headers.isEmpty()){
                        Map<String, String> uniqueIdMAp = new HashMap<>();

                        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
                            try {
                                StudentResponse studentResponse = new StudentResponse();
                                String errorUniqueId = null;
                                XSSFRow row = worksheet.getRow(i);
                                String error = "Error is : ";
                                for (Map.Entry<String,Integer> entry : headers.entrySet() ){
                                    if (row.getc)
                                }

                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }


                    }


                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }

        return List.of();
    }


}
