package com.example.zavrsni_ispit_2025.controller;

import com.example.zavrsni_ispit_2025.entity.Subject;
import com.example.zavrsni_ispit_2025.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@CrossOrigin
@RequiredArgsConstructor
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping
    public List<Subject> getSubject(){
        return service.getSubject();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Integer id){
        return ResponseEntity.of(service.getSubjectById(id));
    }

    @PostMapping
    public void createSubject(@RequestBody Subject model){
        service.createSubject(model);
    }

    @PutMapping(path = "/{id}")
    public void updateSubject(@PathVariable Integer id, @RequestBody Subject model){
        service.updateSubject(id,model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubject(@PathVariable Integer id){
        service.deleteSubject(id);
    }


}