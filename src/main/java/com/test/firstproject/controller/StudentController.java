package com.test.firstproject.controller;

import com.test.firstproject.dto.StudentDto;
import com.test.firstproject.entity.Student;
import com.test.firstproject.model.Project;
import com.test.firstproject.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController //@Controller, @ResponseBody
@CrossOrigin("http://localhost:4200")
@RequestMapping("/sms/api/v1/students")
public class StudentController {

    /*@Autowired
    private StudentService studentService;*/

    @Value("${address}")
    private String address;

    @Value("${welcome.msg}")
    private String welcomeMessage;

    @Autowired
    @Qualifier("project2")
    private Project project;

    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //URL:http://localhost:8080/sms/api/v1/students
    @PostMapping
    public ResponseEntity<String> saveStudent(@Valid @RequestBody StudentDto studentDto){
        Student st2 = Student.builder()
                .fullName(studentDto.getName())
                .build();
        String result = studentService.saveStudent(studentDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("title", "spring boot");
        //return ResponseEntity.ok().headers(httpHeaders).body(result);
        return ResponseEntity.ok(result);
    }

    //URL:http://localhost:8081/sms/api/v1/students/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long sid) {
        System.out.println("ID sent by front end is: "+sid);
        return ResponseEntity.ok(studentService.deleteStudent(sid));
    }

    //URL: http://localhost:8081/sms/api/v1/students
    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudentList() {
        return ResponseEntity.ok(studentService.getStudentList());
    }

    //URL: http://localhost:8081/sms/api/v1/students/4
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long sid) throws Exception {
        return ResponseEntity.ok(studentService.getStudentById(sid));
    }

    //URL: http://localhost:8081/sms/api/v1/students/55
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    //URL: http://localhost:8081/sms/api/v1/students/55
    @PatchMapping("/{id}")
    public String updatePartialStudent(@PathVariable("id") Long id, @RequestBody Student student){
        return studentService.updatePartialStudent(id, student);
    }

    //URL: http://localhost:8081/sms/api/v1/students/bulk
    @PostMapping("/bulk")
    public String saveBulkStudent(@RequestBody List<Student> students){
        return studentService.saveBulkStudent(students);
    }

    //URL: http://localhost:8081/sms/api/v1/students/females
    @GetMapping("/females")
    public List<Student> getFemaleStudents() {
        return studentService.getFemaleStudents();
    }

    @GetMapping("/custom/{gender}")
    public List<Student> getCustomStudents(@PathVariable("gender") String gender) {
        return studentService.getCustomStudents(gender);
    }

    /*@GetMapping("/querymethods/{address}")
    public List<Student> executeQueryMethods(@PathVariable("address") String address) {
        return studentService.executeQueryMethods(address);
    }*/

//    @GetMapping("/querymethods/{address}/{gender}")
//    public List<Student> executeQueryMethodsMultipleFilters(@PathVariable("address") String address,
//                                                            @PathVariable("gender") String gender) {
//        return studentService.executeQueryMethodsMultipleFilters(address, gender);
//    }
}
