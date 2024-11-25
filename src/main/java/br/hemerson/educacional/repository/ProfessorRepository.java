package br.hemerson.educacional.repository;

import br.hemerson.educacional.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
