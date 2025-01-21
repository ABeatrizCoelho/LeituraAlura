package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(@JsonAlias("name") String nomeAutor,
    @JsonAlias("birth_year") Long anoNascimento,
    @JsonAlias("death_year") Long anoFalecimento) {
}
