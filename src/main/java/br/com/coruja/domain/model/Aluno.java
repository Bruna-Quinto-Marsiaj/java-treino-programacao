package br.com.coruja.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno { 

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; 
    @NotNull
    @Column(name="nome")
    private String name;
    private String email;

    

    
    /*public Aluno(Long id, @NotNull String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Aluno(@NotNull String name, String email) {
        this.name = name;
        this.email = email;
    }*/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
