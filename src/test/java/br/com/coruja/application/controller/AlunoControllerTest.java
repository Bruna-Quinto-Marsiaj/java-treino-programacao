package br.com.coruja.application.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.coruja.domain.model.Aluno;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlunoControllerTest {
    @Autowired
    protected WebTestClient web;

    @BeforeEach
    public void setUp() {
        web = web.mutate().responseTimeout(Duration.ofMillis(10000)).build();
    }

    @Test
    public void deve_retornar_201_CREATED() {
        Aluno aluno = new Aluno();
        aluno.setName("Bruna Aluna Preferida");
        aluno.setEmail("brunaalunapreferida@gmail.com");
        web.post().uri("/aluno").accept(MediaType.ALL).bodyValue(aluno)
            .exchange().expectStatus().isCreated().expectBody(Aluno.class)
            .value(c -> assertEquals("Bruna Aluna Preferida", c.getName()))
            .value (d -> assertEquals("brunaalunapreferida@gmail.com", d.getEmail()));
    }

}