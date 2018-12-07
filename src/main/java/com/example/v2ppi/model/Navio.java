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

    public Navio(String nome, Integer quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Navio() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Navio navio = (Navio) o;
        return Objects.equals(id, navio.id) &&
                Objects.equals(nome, navio.nome) &&
                Objects.equals(quantidade, navio.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, quantidade);
    }

    @Override
    public String toString() {
        return "Navio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
