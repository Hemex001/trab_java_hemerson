package br.hemerson.educacional.dto;

import br.hemerson.educacional.model.Aluno;
import br.hemerson.educacional.model.Disciplina;
import br.hemerson.educacional.model.Matricula;
import br.hemerson.educacional.model.Turma;

import java.time.LocalDate;

public record NotaRequestDTO(Integer id, Matricula matriculaId, Disciplina disciplinaId, Double nota, LocalDate dataLancamento) {
}
