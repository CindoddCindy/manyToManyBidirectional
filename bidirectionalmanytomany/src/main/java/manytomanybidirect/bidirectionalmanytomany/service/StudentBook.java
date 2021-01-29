package manytomanybidirect.bidirectionalmanytomany.service;

import manytomanybidirect.bidirectionalmanytomany.dto.StudentBookDto;
import manytomanybidirect.bidirectionalmanytomany.dto.StudentDto;

import java.util.List;

public interface StudentBook {
    public StudentBookDto addStudentBook(StudentBookDto studentBookDto);
    public List<StudentBookDto> getAllStudentsBook();
    public StudentBookDto updateStudentBook(Integer studentId, StudentBookDto studentBookDto);
    public String deleteStudentBook(Integer studentId);
}
