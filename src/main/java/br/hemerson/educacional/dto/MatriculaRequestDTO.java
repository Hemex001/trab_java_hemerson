package br.hemerson.educacional.dto;

import br.hemerson.educacional.model.Aluno;
import br.hemerson.educacional.model.Turma;

public record MatriculaRequestDTO(
        Integer id,
        Aluno alunoId,
        Turma turmaId
) {
}
