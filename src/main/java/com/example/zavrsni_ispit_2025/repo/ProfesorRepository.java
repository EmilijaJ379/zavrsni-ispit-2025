package com.example.zavrsni_ispit_2025.repo;

import com.example.zavrsni_ispit_2025.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

    List<Profesor> findAllByDeletedAtIsNull();

    Optional<Profesor> findByIdAndDeletedAtIsNull(Integer id);

}
