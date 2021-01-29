package manytomanybidirect.bidirectionalmanytomany.controller;


import java.util.List;

import manytomanybidirect.bidirectionalmanytomany.dto.StudentDto;
import manytomanybidirect.bidirectionalmanytomany.dto.StudentDtos;
import manytomanybidirect.bidirectionalmanytomany.service.StudentService;
import manytomanybidirect.bidirectionalmanytomany.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControllers {

    @Autowired
    private StudentServices studentServices;

    @GetMapping("/studentsSchedulle")
    public ResponseEntity<List<StudentDtos>> getAllStudents() {
        List<StudentDtos> students = studentServices.getsAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/studentSchedulle")
    public ResponseEntity<StudentDtos> getAllStudents(@RequestBody StudentDtos studentDtos) {
        StudentDtos std = studentServices.addStudents(studentDtos);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

    /*
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDtos> updateStudent(@PathVariable(name = "id") Integer id,
                                                    @RequestBody StudentDto student) {
        StudentDto std = studentService.updateStudent(id, student);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Integer studentId) {
        String message = studentService.deleteStudent(studentId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

     */
}
