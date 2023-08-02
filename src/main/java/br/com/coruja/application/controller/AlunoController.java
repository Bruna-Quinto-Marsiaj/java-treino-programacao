package br.com.coruja.application.controller;



import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coruja.domain.model.Aluno;
import br.com.coruja.domain.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findAluno(@Positive @PathVariable Long id){
        
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findById(id));// Builder, saber implementar com testes utilizando um builder
       
    }

    @GetMapping
    public ResponseEntity<?> listAlunos(){
    
        //um tipo de builder
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listAlunos());
  }

    @PostMapping
    public ResponseEntity<?> saveAluno(@RequestBody Aluno form){
        alunoService.saveAluno(form);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAluno(@Positive @PathVariable Long id, @RequestBody Aluno form){
        alunoService.updateAluno(id, form);
        
        
        return ResponseEntity.status(HttpStatus.OK).build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable Long id){
        alunoService.deleteAluno(id);
        //um tipo de builder
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}
