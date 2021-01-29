package manytomanybidirect.bidirectionalmanytomany.controller;


import java.util.List;

import manytomanybidirect.bidirectionalmanytomany.dto.StudentBookDto;
import manytomanybidirect.bidirectionalmanytomany.dto.StudentDto;
import manytomanybidirect.bidirectionalmanytomany.service.StudentBook;
import manytomanybidirect.bidirectionalmanytomany.service.StudentService;
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
public class StudentBookController {

    @Autowired
    private StudentBook studentBook;

    @GetMapping("/studentsBook")
    public ResponseEntity<List<StudentBookDto>> getAllStudentsBook() {
        List<StudentBookDto> students = studentBook.getAllStudentsBook();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/studentBook")
    public ResponseEntity<StudentBookDto> postAllStudentsBook(@RequestBody StudentBookDto studentBookDto) {
        StudentBookDto std = studentBook.addStudentBook(studentBookDto);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }
/*
    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable(name = "id") Integer id,
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
