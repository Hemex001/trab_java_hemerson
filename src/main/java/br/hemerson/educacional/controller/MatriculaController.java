package br.hemerson.educacional.controller;


import br.hemerson.educacional.dto.DisciplinaRequestDTO;
import br.hemerson.educacional.dto.MatriculaRequestDTO;
import br.hemerson.educacional.model.Disciplina;
import br.hemerson.educacional.model.Matricula;
import br.hemerson.educacional.repository.DisciplinaRepository;
import br.hemerson.educacional.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;

    @GetMapping
    public ResponseEntity<List<Matricula>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> findById(@PathVariable Integer id) {
        Matricula matricula = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada"));

        return ResponseEntity.ok(matricula);
    }

    @PostMapping
    public ResponseEntity<Matricula> save(@RequestBody MatriculaRequestDTO dto) {
        Matricula matricula = new Matricula();
        matricula.setAluno(dto.alunoId());
        matricula.setTurma(dto.turmaId());

        Matricula savedMatricula = this.repository.save(matricula);
        return ResponseEntity.ok(savedMatricula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> update(@PathVariable Integer id, @RequestBody MatriculaRequestDTO dto) {
        Matricula matricula = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada"));

        matricula.setAluno(dto.alunoId());
        matricula.setTurma(dto.turmaId());

        Matricula updatedMatricula  = this.repository.save(matricula);
        return ResponseEntity.ok(updatedMatricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Matricula matricula = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada"));

        this.repository.delete(matricula);
        return ResponseEntity.noContent().build();
    }
}
