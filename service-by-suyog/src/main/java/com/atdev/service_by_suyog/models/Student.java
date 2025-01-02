package com.atdev.service_by_suyog.models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_key")
    private Long studentKey;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private String dob;

    @Column(name = "mobile_num")
    private String mobileNum;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "address")
    private String address;

    @Column(name = "taluka")
    private Long taluka;

    @Column(name = "district")
    private Long district;

    @Column(name = "dt_of_admsn")
    private String dtOfAdmsn;

    @Column(name = "handicapped")
    private String handicapped;

    public Student() {
    }

    @Builder
    public Student(Long studentKey, String firstName, String middleName, String lastName, String motherName, String gender, String dob, String mobileNum, String qualification, String address, Long taluka, Long district, String dtOfAdmsn, String handicapped) {
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
