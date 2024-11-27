package br.hemerson.educacional.dto;

import br.hemerson.educacional.model.Curso;
import br.hemerson.educacional.model.Professor;

public record DisciplinaRequestDTO(
        Integer id,
        String nome,
        String codigo,
        Curso cursoId,
        Professor professorId
) {
}
