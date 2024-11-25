package br.hemerson.educacional.controller;

import br.hemerson.educacional.dto.TurmaRequestDTO;
import br.hemerson.educacional.model.Turma;
import br.hemerson.educacional.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {
    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id) {
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        return ResponseEntity.ok(turma);
    }

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody TurmaRequestDTO dto) {
        Turma turma = new Turma();
        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());
        turma.setCurso(dto.cursoId());

        Turma savedTurma = this.repository.save(turma);
        return ResponseEntity.ok(savedTurma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@PathVariable Integer id, @RequestBody TurmaRequestDTO dto) {
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada")); // Use RuntimeException para um exemplo simples

        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());
        turma.setCurso(dto.cursoId());

        Turma updatedTurma = this.repository.save(turma);
        return ResponseEntity.ok(updatedTurma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada")); // Use RuntimeException para um exemplo simples

        this.repository.delete(turma);
        return ResponseEntity.noContent().build();
    }
}