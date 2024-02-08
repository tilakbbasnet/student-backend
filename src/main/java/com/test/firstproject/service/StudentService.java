package com.test.firstproject.service;

import com.test.firstproject.dto.StudentDto;
import com.test.firstproject.entity.Address;
import com.test.firstproject.entity.Student;
import com.test.firstproject.exception.ResourceNotFoundException;
import com.test.firstproject.mapper.StudentMapper;
import com.test.firstproject.repository.AddressRepository;
import com.test.firstproject.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StudentService {

    /*@Autowired
    private StudentRepository studentRepository;
    */

    /*
    * @Transactional
    * fundTransfer(){
    * You: $1000
    * Friend: $200
    * 1. Subtract $500 from your account
    * //Update account set amount=amount-500 where account_id=123
    * exception/error
    * 2. Add $500 to friend's account
    * //Update account set amount=amount+500 where account_id=456
    * }
    *
    * --Node JS
    *
    * */

    private final StudentRepository studentRepository;

    private final AddressRepository addressRepository;

    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository){
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    public String saveStudent(StudentDto studentDto) {/*
        Student copyStudent = student;
        copyStudent.setAddresses(new HashSet<>());
        student.getAddresses().forEach(address -> {
            Address existingAddress = null;
            existingAddress = addressRepository.findByCityAndStateAndType(address.getCity(), address.getState(), address.getType());
            if(existingAddress == null) {
                copyStudent.getAddresses().add(existingAddress);
            }
        });*/

        //Using Bean Utils
//        Student student = new Student();
//        BeanUtils.copyProperties(studentDto, student);

        //Using Mapper class
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
        return "Student saved successfully!";
    }

    public String deleteStudent(Long id) {
        //checking if student having id exists or not
        if(studentRepository.existsById(id)) { //If student exists
            studentRepository.deleteById(id);
            return "success";
        }
        //not exists
        throw new ResourceNotFoundException("Student not found with id "+id);
    }

    public List<StudentDto> getStudentList() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for(Student student : students) {
            //studentDtos.add(new StudentDto(student.getFullName(), student.getEmail()));

            //Using Bean Utils
//            StudentDto studentDto = new StudentDto();
//            BeanUtils.copyProperties(student, studentDto);

            //Using Mapper class
            StudentDto studentDto = StudentMapper.mapToStudentDto(student);
            studentDtos.add(studentDto);
        }
        //return studentRepository.findAll();
        return studentDtos;
    }

    public Student getStudentById(Long id) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            return student.get();
        }
        throw new ResourceNotFoundException("Student having id "+id+" not found!");
    }

    public String updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist"));
        existingStudent.setFullName(student.getFullName());
        //existingStudent.setAddress(student.getAddress());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setGender(student.getGender());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setLevel(student.getLevel());

        //Removing existing address
        existingStudent.getAddresses().clear();
        //Adding new address to the student
        existingStudent.getAddresses().addAll(student.getAddresses());


        studentRepository.save(existingStudent);
        return "Student updated successfully";
    }

    public String updatePartialStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id) //Return student data if student with id exists else throw exception
                .orElseThrow(()->new ResourceNotFoundException("Student does not exist."));
        if(student.getFullName() != null) { //Set the value to the existing
            existingStudent.setFullName(student.getFullName());
        }
//        if(student.getAddress() != null) {
//            existingStudent.setAddress(student.getAddress());
//        }
        if(student.getEmail() != null) {
            existingStudent.setEmail(student.getEmail());
        }
        if(student.getGender() != null){
            existingStudent.setGender(student.getGender());
        }
        if(student.getLevel() != null){
            existingStudent.setLevel(student.getLevel());
        }
        if(student.getPhone() != null){
            existingStudent.setPhone(student.getPhone());
        }
        studentRepository.save(existingStudent);
        return "Student partially updated successfully";
    }

    public String saveBulkStudent(List<Student> students) {
        studentRepository.saveAll(students);
        return "Students saved successfully";
    }

    public List<Student> getFemaleStudents() {
        return studentRepository.getFemaleStudents();
    }

    public List<Student> getCustomStudents(String gender) {
        return studentRepository.getCustomStudents(gender);
    }

//    public List<Student> executeQueryMethods(String address) {
//        return studentRepository.findStudentByAddress(address);
//    }

    //Spring data jpa query methods
//    public List<Student> executeQueryMethodsMultipleFilters(String address, String gender) {
//        return studentRepository.findStudentByAddressEndingWithAndGender(address, gender);
//    }
}
