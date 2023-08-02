package br.com.coruja.domain.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coruja.domain.model.Aluno;
import br.com.coruja.domain.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    
     public Aluno findById(Long id){
        
        return alunoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("O id: " + id));
    }

    
    
    public List<Aluno> listAlunos(){

        return alunoRepository.findAll();
    }

    
    public Aluno saveAluno(Aluno aluno){
        
        return alunoRepository.save(aluno);
    }

    public void updateAluno(Long id, Aluno form){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("O id: " + id));
        
            aluno.setName(form.getName());
            aluno.setEmail(form.getEmail());
            alunoRepository.save(aluno);
    }
 

 
    public void deleteAluno(Long id){// tirei aluno e botei void
         Optional<Aluno> aluno  = alunoRepository.findById(id);
         if (aluno.isPresent()){
           alunoRepository.deleteById(id); 
         }
    
    }
    
}
