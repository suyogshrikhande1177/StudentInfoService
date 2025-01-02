package com.atdev.service_by_suyog.payload.response;

import com.atdev.service_by_suyog.payload.request.StudentRequest;

public class StudentResponse extends StudentRequest {
private Long studentKey;

    @Override
    public Long getStudentKey() {
        return studentKey;
    }

    @Override
    public void setStudentKey(Long studentKey) {
        this.studentKey = studentKey;
    }
}
