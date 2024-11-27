package br.hemerson.educacional.controller;

import br.hemerson.educacional.dto.MatriculaRequestDTO;
import br.hemerson.educacional.dto.NotaRequestDTO;
import br.hemerson.educacional.model.Matricula;
import br.hemerson.educacional.model.Nota;
import br.hemerson.educacional.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaController {
    @Autowired
    private NotaRepository repository;


    @GetMapping
    public ResponseEntity<List<Nota>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> findById(@PathVariable Integer id) {
        Nota nota = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota não encontrada"));

        return ResponseEntity.ok(nota);
    }

    @PostMapping
    public ResponseEntity<Nota> save(@RequestBody NotaRequestDTO dto) {
        Nota nota = new Nota();
        nota.setMatricula(dto.matriculaId());
        nota.setDisciplina(dto.disciplinaId());
        nota.setNota(dto.nota());
        nota.setDataLancamento(dto.dataLancamento());

        Nota savedNota = this.repository.save(nota);
        return ResponseEntity.ok(savedNota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> update(@PathVariable Integer id, @RequestBody NotaRequestDTO dto) {
        Nota nota = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota não encontrada"));

        nota.setMatricula(dto.matriculaId());
        nota.setDisciplina(dto.disciplinaId());
        nota.setNota(dto.nota());
        nota.setDataLancamento(dto.dataLancamento());

        Nota updatedNota  = this.repository.save(nota);
        return ResponseEntity.ok(updatedNota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Nota nota = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota não encontrada"));

        this.repository.delete(nota);
        return ResponseEntity.noContent().build();
    }
}
