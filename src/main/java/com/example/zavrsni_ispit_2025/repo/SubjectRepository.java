package com.example.zavrsni_ispit_2025.repo;

import com.example.zavrsni_ispit_2025.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    List<Subject> findAllByDeletedAtIsNull();

    Optional<Subject> findByIdAndDeletedAtIsNull(Integer id);

}
