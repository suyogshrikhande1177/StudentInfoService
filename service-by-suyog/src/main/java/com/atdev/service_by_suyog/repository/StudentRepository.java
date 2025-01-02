package com.atdev.service_by_suyog.repository;

import com.atdev.service_by_suyog.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(nativeQuery = true, value = "select * from student")
    List<Object[]> getAllStudent();
}
