package manytomanybidirect.bidirectionalmanytomany.service;

import manytomanybidirect.bidirectionalmanytomany.dto.StudentDto;
import manytomanybidirect.bidirectionalmanytomany.dto.StudentDtos;

import java.util.List;

public interface StudentServices {
    public StudentDtos addStudents(StudentDtos studentDtos);
    public List<StudentDtos> getsAllStudents();
    public StudentDtos updateStudents(Integer schedulleId, StudentDtos student);
    public String deleteStudents(Integer schedulleId);

}
