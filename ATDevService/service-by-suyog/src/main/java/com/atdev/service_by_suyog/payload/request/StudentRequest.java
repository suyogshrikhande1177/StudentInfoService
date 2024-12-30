package com.atdev.service_by_suyog.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class StudentRequest {
    @JsonProperty("studentKey")
    private Long studentKey;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("motherName")
    private String motherName;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("mobileNum")
    private String mobileNum;

    @JsonProperty("qualification")
    private String qualification;

    @JsonProperty("address")
    private String address;

    @JsonProperty("taluka")
    private Long taluka;

    @JsonProperty("district")
    private Long district;

    @JsonProperty("dtOfAdmsn")
    private String dtOfAdmsn;

    @JsonProperty("handicapped")
    private String handicapped;

    @Builder
    public StudentRequest() {
    }

    @Builder
    public StudentRequest(Long studentKey, String firstName, String middleName, String lastName, String motherName, String gender, String dob, String mobileNum, String qualification, String address, Long taluka, Long district, String dtOfAdmsn, String handicapped) {
        this.studentKey = studentKey;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.motherName = motherName;
        this.gender = gender;
        this.dob = dob;
        this.mobileNum = mobileNum;
        this.qualification = qualification;
        this.address = address;
        this.taluka = taluka;
        this.district = district;
        this.dtOfAdmsn = dtOfAdmsn;
        this.handicapped = handicapped;
    }

    public Long getStudentKey() {
        return studentKey;
    }

    public void setStudentKey(Long studentKey) {
        this.studentKey = studentKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTaluka() {
        return taluka;
    }

    public void setTaluka(Long taluka) {
        this.taluka = taluka;
    }

    public Long getDistrict() {
        return district;
    }

    public void setDistrict(Long district) {
        this.district = district;
    }

    public String getDtOfAdmsn() {
        return dtOfAdmsn;
    }

    public void setDtOfAdmsn(String dtOfAdmsn) {
        this.dtOfAdmsn = dtOfAdmsn;
    }

    public String getHandicapped() {
        return handicapped;
    }

    public void setHandicapped(String handicapped) {
        this.handicapped = handicapped;
    }
}
