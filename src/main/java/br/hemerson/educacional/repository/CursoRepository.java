package br.hemerson.educacional.repository;

import br.hemerson.educacional.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
