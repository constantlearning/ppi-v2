package com.example.ppiv2.model;

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

    private Integer quantidadePessoas;

    public Navio(String nome, Integer quantidadePessoas) {
        this.nome = nome;
        this.quantidadePessoas = quantidadePessoas;
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

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Navio navio = (Navio) o;
        return Objects.equals(id, navio.id) &&
                Objects.equals(nome, navio.nome) &&
                Objects.equals(quantidadePessoas, navio.quantidadePessoas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, quantidadePessoas);
    }

    @Override
    public String toString() {
        return "Navio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantidadePessoas=" + quantidadePessoas +
                '}';
    }
}
