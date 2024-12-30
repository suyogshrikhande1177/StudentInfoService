package com.atdev.service_by_suyog.mapper;

import com.atdev.service_by_suyog.models.Student;
import com.atdev.service_by_suyog.payload.request.StudentRequest;
import com.atdev.service_by_suyog.payload.response.StudentResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-29T00:54:05+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentRequest studentRequest) {
        if ( studentRequest == null ) {
            return null;
        }

        Student student = new Student();

        student.setStudentKey( studentRequest.getStudentKey() );
        student.setFirstName( studentRequest.getFirstName() );
        student.setMiddleName( studentRequest.getMiddleName() );
        student.setLastName( studentRequest.getLastName() );
        student.setMotherName( studentRequest.getMotherName() );
        student.setGender( studentRequest.getGender() );
        student.setDob( studentRequest.getDob() );
        student.setMobileNum( studentRequest.getMobileNum() );
        student.setQualification( studentRequest.getQualification() );
        student.setAddress( studentRequest.getAddress() );
        student.setTaluka( studentRequest.getTaluka() );
        student.setDistrict( studentRequest.getDistrict() );
        student.setDtOfAdmsn( studentRequest.getDtOfAdmsn() );
        student.setHandicapped( studentRequest.getHandicapped() );

        return student;
    }

    @Override
    public StudentResponse toResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setFirstName( student.getFirstName() );
        studentResponse.setMiddleName( student.getMiddleName() );
        studentResponse.setLastName( student.getLastName() );
        studentResponse.setMotherName( student.getMotherName() );
        studentResponse.setGender( student.getGender() );
        studentResponse.setDob( student.getDob() );
        studentResponse.setMobileNum( student.getMobileNum() );
        studentResponse.setQualification( student.getQualification() );
        studentResponse.setAddress( student.getAddress() );
        studentResponse.setTaluka( student.getTaluka() );
        studentResponse.setDistrict( student.getDistrict() );
        studentResponse.setDtOfAdmsn( student.getDtOfAdmsn() );
        studentResponse.setHandicapped( student.getHandicapped() );
        studentResponse.setStudentKey( student.getStudentKey() );

        return studentResponse;
    }

    @Override
    public List<StudentResponse> toResponseList(List<Student> student) {
        if ( student == null ) {
            return null;
        }

        List<StudentResponse> list = new ArrayList<StudentResponse>( student.size() );
        for ( Student student1 : student ) {
            list.add( toResponse( student1 ) );
        }

        return list;
    }

    @Override
    public void update(Student student, StudentRequest studentRequest) {
        if ( studentRequest == null ) {
            return;
        }

        student.setFirstName( studentRequest.getFirstName() );
        student.setMiddleName( studentRequest.getMiddleName() );
        student.setLastName( studentRequest.getLastName() );
        student.setMotherName( studentRequest.getMotherName() );
        student.setGender( studentRequest.getGender() );
        student.setDob( studentRequest.getDob() );
        student.setMobileNum( studentRequest.getMobileNum() );
        student.setQualification( studentRequest.getQualification() );
        student.setAddress( studentRequest.getAddress() );
        student.setTaluka( studentRequest.getTaluka() );
        student.setDistrict( studentRequest.getDistrict() );
        student.setDtOfAdmsn( studentRequest.getDtOfAdmsn() );
        student.setHandicapped( studentRequest.getHandicapped() );
    }

    @Override
    public List<Student> toEntityList(List<StudentRequest> studentRequests) {
        if ( studentRequests == null ) {
            return null;
        }

        List<Student> list = new ArrayList<Student>( studentRequests.size() );
        for ( StudentRequest studentRequest : studentRequests ) {
            list.add( toEntity( studentRequest ) );
        }

        return list;
    }
}
