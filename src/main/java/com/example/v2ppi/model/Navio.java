package com.example.v2ppi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Navio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer quantidade;

    private Double tamanho;

    private String nacionalidade;

    public Navio() {
    }

    public Navio(String nome, Integer quantidade, Double tamanho, String nacionalidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Navio navio = (Navio) o;
        return Objects.equals(id, navio.id) &&
                Objects.equals(nome, navio.nome) &&
                Objects.equals(quantidade, navio.quantidade) &&
                Objects.equals(tamanho, navio.tamanho) &&
                Objects.equals(nacionalidade, navio.nacionalidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, quantidade, tamanho, nacionalidade);
    }

    @Override
    public String toString() {
        return "Navio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", tamanho=" + tamanho +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}
