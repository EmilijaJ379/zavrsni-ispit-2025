package com.example.zavrsni_ispit_2025.service;

import com.example.zavrsni_ispit_2025.entity.Profesor;
import com.example.zavrsni_ispit_2025.repo.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    @Autowired
    private  ProfesorRepository profesorRepository;

    public List<Profesor> getProfesor() {
        return profesorRepository.findAllByDeletedAtIsNull();
    }

    public Optional<Profesor> getProfesorById(Integer id) {
        return profesorRepository.findByIdAndDeletedAtIsNull(id);
    }

    public Profesor createProfesor(Profesor model){
        Profesor profesor = new Profesor();
        profesor.setFirstName(model.getFirstName());
        profesor.setLastName(model.getLastName());
        profesor.setEmail(model.getEmail());
        profesor.setCreatedAt(LocalDateTime.now());
        return profesorRepository.save(profesor);
    }

    public Profesor updateProfesor(Integer id, Profesor model){
        Profesor profesor = getProfesorById(id).orElseThrow();profesor.setFirstName(model.getFirstName());
        profesor.setLastName(model.getLastName());
        profesor.setEmail(model.getEmail());
        profesor.setUpdatedAt(LocalDateTime.now());
        return profesorRepository.save(profesor);
    }

    public void deleteProfesor(Integer id){
        Profesor profesor = getProfesorById(id).orElseThrow();
        profesor.setDeletedAt(LocalDateTime.now());
        profesorRepository.save(profesor);
    }
}
