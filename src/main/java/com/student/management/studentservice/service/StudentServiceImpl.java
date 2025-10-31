package com.student.management.studentservice.service;

import com.student.management.studentservice.dto.StudentDTO;
import com.student.management.studentservice.entity.Student;
import com.student.management.studentservice.mapper.StudentMapper;
import com.student.management.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public StudentDTO create(StudentDTO dto) {
        if (repo.existsByRollNumber(dto.getRollNumber()))
            throw new IllegalArgumentException("Roll number already exists");
        Student s = StudentMapper.toEntity(dto);
        return StudentMapper.toDTO(repo.save(s));
    }

    @Override
    public List<StudentDTO> getAll() {
        return repo.findAll().stream().map(StudentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getById(Long id) {
        Student s = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return StudentMapper.toDTO(s);
    }

    @Override
    @Transactional
    public StudentDTO update(Long id, StudentDTO dto) {
        Student existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        if (!existing.getRollNumber().equals(dto.getRollNumber()) && repo.existsByRollNumber(dto.getRollNumber()))
            throw new IllegalArgumentException("Roll number already exists");
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setRollNumber(dto.getRollNumber());
        existing.setDateOfBirth(dto.getDateOfBirth());
        return StudentMapper.toDTO(repo.save(existing));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
