package br.hemerson.educacional.dto;

import br.hemerson.educacional.model.Curso;

public record TurmaRequestDTO(Integer ano, Integer semestre, Curso cursoId) {
}
