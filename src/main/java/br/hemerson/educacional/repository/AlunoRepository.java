package br.hemerson.educacional.repository;

import br.hemerson.educacional.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
