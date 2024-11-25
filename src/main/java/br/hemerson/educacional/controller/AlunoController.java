package br.hemerson.educacional.controller;


import br.hemerson.educacional.dto.AlunoRequestDTO;
import br.hemerson.educacional.model.Aluno;
import br.hemerson.educacional.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(this.alunoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
        Aluno aluno = this.alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setMatricula(dto.matricula());
        aluno.setDataNascimento(dto.dataNascimento());

        Aluno savedAluno = this.alunoRepository.save(aluno);
        return ResponseEntity.ok(savedAluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Integer id, @RequestBody AlunoRequestDTO dto) {
        Aluno aluno = this.alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado")); // Use RuntimeException para um exemplo simples

        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setMatricula(dto.matricula());
        aluno.setDataNascimento(dto.dataNascimento());

        Aluno updatedAluno = this.alunoRepository.save(aluno);
        return ResponseEntity.ok(updatedAluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Aluno aluno = this.alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        this.alunoRepository.delete(aluno);
        return ResponseEntity.noContent().build();
    }

}
