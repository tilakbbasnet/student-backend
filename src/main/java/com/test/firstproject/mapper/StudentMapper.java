package com.test.firstproject.mapper;

import com.test.firstproject.dto.StudentDto;
import com.test.firstproject.entity.Student;

public class StudentMapper {

    //Method to convert Student Entity to StudentDto
    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto(
                student.getFullName(),
                student.getEmail(),
                student.getGender(),
                student.getPhone(),
                student.getLevel());
        return studentDto;
    }

    //Method to convert StudentDto to Student Entity
    public static Student mapToStudent(StudentDto studentDto) {
        Student student = Student.builder()
                .fullName(studentDto.getName())
                .email(studentDto.getEmailAddress())
                .gender(studentDto.getGender())
                .phone(studentDto.getPhoneNumber())
                .level(studentDto.getLevel()).build();
        return student;
    }

}
