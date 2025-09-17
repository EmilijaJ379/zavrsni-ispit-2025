package com.example.zavrsni_ispit_2025.service;

import com.example.zavrsni_ispit_2025.entity.Profesor;
import com.example.zavrsni_ispit_2025.entity.Subject;
import com.example.zavrsni_ispit_2025.repo.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getSubject() {
        return subjectRepository.findAllByDeletedAtIsNull();
    }

    public Optional<Subject> getSubjectById(Integer id) {
        return subjectRepository.findByIdAndDeletedAtIsNull(id);
    }

    public void createSubject(Subject model){
        Subject subject = new Subject();
        subject.setName(model.getName());

        Profesor profesor = new Profesor();
        profesor.setId(model.getProfesor().getId());
        subject.setProfesor(profesor);

        subject.setYear(model.getYear());
        subject.setCreatedAt(LocalDateTime.now());
        subjectRepository.save(model);
    }

    public void updateSubject(Integer id, Subject model){
        Subject subject = this.getSubjectById(id).orElseThrow();
        subject.setName(model.getName());

        Profesor profesor = new Profesor();
        profesor.setId(model.getProfesor().getId());
        subject.setProfesor(profesor);

        subject.setYear(model.getYear());
        subject.setUpdatedAt(LocalDateTime.now());
        subjectRepository.save(model);
    }

    public void deleteSubject(Integer id){
        Subject subject = getSubjectById(id).orElseThrow();
        subject.setDeletedAt(LocalDateTime.now());
        subjectRepository.save(subject);
    }
}
