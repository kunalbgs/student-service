package com.student.management.studentservice.mapper;

import com.student.management.studentservice.dto.StudentDTO;
import com.student.management.studentservice.entity.Student;

public class StudentMapper {

    public static Student toEntity(StudentDTO dto) {
        if (dto == null) return null;
        Student s = new Student();
        s.setId(dto.getId());
        s.setRollNumber(dto.getRollNumber());
        s.setName(dto.getName());
        s.setEmail(dto.getEmail());
        s.setDateOfBirth(dto.getDateOfBirth());
        return s;
    }

    public static StudentDTO toDTO(Student s) {
        if (s == null) return null;
        StudentDTO dto = new StudentDTO();
        dto.setId(s.getId());
        dto.setRollNumber(s.getRollNumber());
        dto.setName(s.getName());
        dto.setEmail(s.getEmail());
        dto.setDateOfBirth(s.getDateOfBirth());
        return dto;
    }
}
