package com.test.firstproject.repository;

import com.test.firstproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //retrieving female students SQL
    @Query(value = "SELECT * FROM student where gender='Female'", nativeQuery = true)
    public List<Student> getFemaleStudents();

    @Query(value = "SELECT * FROM student where gender=:gender", nativeQuery = true)
    public List<Student> getCustomStudents(String gender);

    //QueryMethods
    //public List<Student> findStudentByAddress(String address);

    //public List<Student> findStudentByAddressEndingWithAndGender(String address, String gender);
}
