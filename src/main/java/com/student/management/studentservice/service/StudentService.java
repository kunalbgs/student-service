package com.student.management.studentservice.service;

import com.student.management.studentservice.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    StudentDTO create(StudentDTO dto);
    List<StudentDTO> getAll();
    StudentDTO getById(Long id);
    StudentDTO update(Long id, StudentDTO dto);
    void delete(Long id);
}
