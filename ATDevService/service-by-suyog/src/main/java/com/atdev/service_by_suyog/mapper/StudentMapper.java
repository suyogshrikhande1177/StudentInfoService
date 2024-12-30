package com.atdev.service_by_suyog.mapper;

import com.atdev.service_by_suyog.models.Student;
import com.atdev.service_by_suyog.payload.request.StudentRequest;
import com.atdev.service_by_suyog.payload.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toEntity(StudentRequest studentRequest);

    StudentResponse toResponse(Student student);

    List<StudentResponse> toResponseList(List<Student> student);

    @Mapping(target = "studentKey", ignore = true)
    void update(@MappingTarget Student student, StudentRequest studentRequest);

    List<Student> toEntityList(List<StudentRequest> studentRequests);

    //List<StudentResponse> mapListEntityToListResponse(List<Student> students);

}
