package br.hemerson.educacional.repository;

import br.hemerson.educacional.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
}
