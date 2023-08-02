package br.com.coruja.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.coruja.domain.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long > {
    
}
