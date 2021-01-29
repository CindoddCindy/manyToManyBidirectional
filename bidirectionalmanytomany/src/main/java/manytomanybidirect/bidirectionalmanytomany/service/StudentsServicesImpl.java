package manytomanybidirect.bidirectionalmanytomany.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import manytomanybidirect.bidirectionalmanytomany.dto.StudentDto;
import manytomanybidirect.bidirectionalmanytomany.dto.StudentDtos;
import manytomanybidirect.bidirectionalmanytomany.model.Course;
import manytomanybidirect.bidirectionalmanytomany.model.Schedulle;
import manytomanybidirect.bidirectionalmanytomany.model.Student;
import manytomanybidirect.bidirectionalmanytomany.repository.CourseRepository;
import manytomanybidirect.bidirectionalmanytomany.repository.SchedulleRepository;
import manytomanybidirect.bidirectionalmanytomany.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentsServicesImpl implements StudentServices {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private SchedulleRepository schedulleRepository;

    @Transactional
    @Override
    public StudentDtos addStudents(StudentDtos studentDtos) {
        Student student = new Student();
        mapDtoToEntity(studentDtos, student);
        Student savedStudent = studentRepository.save(student);
        return mapEntityToDto(savedStudent);
    }

    @Override
    public List<StudentDtos> getsAllStudents() {
        List<StudentDtos> studentDtos = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        students.stream().forEach(student -> {
            StudentDtos studentDto = mapEntityToDto(student);
            studentDtos.add(studentDto);
        });
        return studentDtos;
    }

    @Transactional
    @Override
    public StudentDtos updateStudents(Integer id, StudentDtos studentDtos) {
        Student std = studentRepository.getOne(id);
        std.getSchedulles().clear();
        mapDtoToEntity(studentDtos, std);
        Student student = studentRepository.save(std);
        return mapEntityToDto(student);
    }

    @Override
    public String deleteStudents(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        //Remove the related courses from student entity.
        if(student.isPresent()) {
            student.get().removeSchedulle();
            studentRepository.deleteById(student.get().getId());
            return "Student with id: " + studentId + " deleted successfully!";
        }
        return null;
    }

    private void mapDtoToEntity(StudentDtos studentDtos, Student student) {
        student.setName(studentDtos.getName());
        if (null == student.getSchedulles()) {
            student.setSchedulles(new HashSet<>());
        }
        studentDtos.getSchedulle().stream().forEach(schedulleName -> {
            Schedulle schedulle = schedulleRepository.findByName(schedulleName);
            if (null == schedulle) {
                schedulle = new Schedulle();
                schedulle.setStudents(new HashSet<>());
            }
            schedulle.setName(schedulleName);
            student.addSchedulle(schedulle);
        });
    }

    private StudentDtos mapEntityToDto(Student student) {
        StudentDtos responseDtos = new StudentDtos();
        responseDtos.setName(student.getName());
        responseDtos.setId(student.getId());
        responseDtos.setSchedulle(student.getSchedulles().stream().map(Schedulle::getName).collect(Collectors.toSet()));
        return responseDtos;
    }
}
