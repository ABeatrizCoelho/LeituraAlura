package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String titulo;
    private String linguagem;
    private Long totalDownloads;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Autor> autores;

    public Livro() {
    }

    public Livro(DadosLivro dadosLivro) {
        this.autor = dadosLivro.autores().get(0).nomeAutor();
        this.titulo = dadosLivro.titulo();
        this.linguagem = dadosLivro.idioma().toString();
        this.totalDownloads = dadosLivro.totalDownloads();
        this.autores = new ArrayList<>();

        for (DadosAutor dadosAutor : dadosLivro.autores()) {
            Autor autor = new Autor(dadosAutor);
            autor.setLivro(this);
            this.autores.add(autor);
        }
    }

    @Override
    public String toString() {
        return "Livro" + titulo + '\'' +
                ", linguagem='" + linguagem + '\'' +
                ", totalDownloads=" + totalDownloads +
                ", autores=" + autores;
    }
}
