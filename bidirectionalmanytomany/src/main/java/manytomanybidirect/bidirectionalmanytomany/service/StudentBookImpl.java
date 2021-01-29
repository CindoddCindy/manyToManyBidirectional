package manytomanybidirect.bidirectionalmanytomany.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import manytomanybidirect.bidirectionalmanytomany.dto.StudentBookDto;
import manytomanybidirect.bidirectionalmanytomany.dto.StudentDto;
import manytomanybidirect.bidirectionalmanytomany.model.Course;
import manytomanybidirect.bidirectionalmanytomany.model.Student;
import manytomanybidirect.bidirectionalmanytomany.onetomany.model.Book;
import manytomanybidirect.bidirectionalmanytomany.onetomany.repository.BookRepository;
import manytomanybidirect.bidirectionalmanytomany.repository.CourseRepository;
import manytomanybidirect.bidirectionalmanytomany.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentBookImpl implements StudentBook {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private BookRepository bookRepository;

    @Transactional
    @Override
    public StudentBookDto addStudentBook(StudentBookDto studentBookDto) {
        Student student = new Student();
        mapDtoToEntity(studentBookDto, student);
        Student savedStudent = studentRepository.save(student);
        return mapEntityToDto(savedStudent);
    }

    @Override
    public List<StudentBookDto> getAllStudentsBook() {
        List<StudentBookDto> studentBookDtos = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        students.stream().forEach(student -> {
            StudentBookDto studentBookDto = mapEntityToDto(student);
            studentBookDtos.add(studentBookDto);
        });
        return studentBookDtos;
    }

    @Override
    public StudentBookDto updateStudentBook(Integer studentId, StudentBookDto studentBookDto) {
        return null;
    }

    @Override
    public String deleteStudentBook(Integer studentId) {
        return null;
    }
/*
    @Transactional
    @Override
    public StudentDto updateStudent(Integer id, StudentDto studentDto) {
        Student std = studentRepository.getOne(id);
        std.getCourses().clear();
        mapDtoToEntity(studentDto, std);
        Student student = studentRepository.save(std);
        return mapEntityToDto(student);
    }

    @Override
    public String deleteStudent(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        //Remove the related courses from student entity.
        if(student.isPresent()) {
            student.get().removeCourses();
            studentRepository.deleteById(student.get().getId());
            return "Student with id: " + studentId + " deleted successfully!";
        }
        return null;
    }

 */

    private void mapDtoToEntity(StudentBookDto studentBookDto, Student student) {
        student.setName(studentBookDto.getName());
        if (null == student.getBooks()) {
            student.setBooks(new HashSet<>());
        }
        studentBookDto.getBooks().stream().forEach(bookName -> {
            Book book = bookRepository.findByName(bookName);
            if (null == book) {
                book = new Book();
                book.setStudents(new HashSet<>());
            }
            //course.setName(courseName);
            student.addBook(book);
        });
    }

    private StudentBookDto mapEntityToDto(Student student) {
        StudentBookDto responseDto = new StudentBookDto();
        responseDto.setName(student.getName());
        responseDto.setId(student.getId());
        responseDto.setBooks(student.getCourses().stream().map(Course::getName).collect(Collectors.toSet()));
        return responseDto;
    }

}
