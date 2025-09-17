package com.example.zavrsni_ispit_2025.controller;

import com.example.zavrsni_ispit_2025.entity.Profesor;
import com.example.zavrsni_ispit_2025.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
@CrossOrigin
@RequiredArgsConstructor
public class ProfesorController {

    @Autowired
    private ProfesorService service;

    @GetMapping
    public List<Profesor> getProfesor(){
        return service.getProfesor();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Integer id){
        return ResponseEntity.of(service.getProfesorById(id));
    }

    @PostMapping
    public Profesor createProfesor(@RequestBody Profesor model){
        return service.createProfesor(model);
    }

    @PutMapping(path = "/{id}")
    public Profesor updateProfesor(@PathVariable Integer id, @RequestBody Profesor model){
        return service.updateProfesor(id,model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfesor(@PathVariable Integer id){
        service.deleteProfesor(id);
    }

}