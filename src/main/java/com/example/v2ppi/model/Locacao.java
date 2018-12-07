package com.example.v2ppi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Veiculo veiculo;

    @ManyToOne
    private Pessoa pessoa;

    public Locacao() {
        pessoa = new Pessoa();
        veiculo = new Veiculo();
    }

    public Locacao(Veiculo veiculo, Pessoa pessoa) {
        this.veiculo = veiculo;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Locacao locacao = (Locacao) o;
        return Objects.equals(id, locacao.id) &&
                Objects.equals(veiculo, locacao.veiculo) &&
                Objects.equals(pessoa, locacao.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, veiculo, pessoa);
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", veiculo=" + veiculo +
                ", pessoa=" + pessoa +
                '}';
    }
}
