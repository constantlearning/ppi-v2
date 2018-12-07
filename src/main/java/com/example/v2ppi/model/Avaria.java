package com.example.v2ppi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Avaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double valor;

    @ManyToMany(mappedBy = "avarias", cascade = CascadeType.ALL)
    private List<Locacao> locacoes;

    public Avaria(String descricao, Double valor, List<Locacao> locacoes) {
        this.descricao = descricao;
        this.valor = valor;
        this.locacoes = locacoes;
    }

    public Avaria() {
        locacoes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Avaria avaria = (Avaria) o;
        return Objects.equals(id, avaria.id) &&
                Objects.equals(descricao, avaria.descricao) &&
                Objects.equals(valor, avaria.valor) &&
                Objects.equals(locacoes, avaria.locacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, locacoes);
    }

    @Override
    public String toString() {
        return "Avaria{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", locacoes=" + locacoes +
                '}';
    }

}
