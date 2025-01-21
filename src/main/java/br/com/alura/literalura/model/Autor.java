package br.com.alura.literalura.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "autores")
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAutor;
    private Long dataNascimento;
    private Long dataFalecimento;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Autor() {

    }

    public Autor(DadosAutor dadosAutor) {
        this.nomeAutor = dadosAutor.nomeAutor();
        this.dataNascimento = dadosAutor.anoNascimento();
        this.dataFalecimento = dadosAutor.anoFalecimento();
    }

    @Override
    public String toString() {
        return "Autor" + id + ", nomeAutor= " + nomeAutor + '\'' + ", dataNascimento= " + dataNascimento
                + ", dataFalecimento= " + dataFalecimento + ", livro= " + livro;
    }
}
