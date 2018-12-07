package com.example.ppiv2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Veiculo vehicle;

    @ManyToOne
    @JsonIgnoreProperties("locacoes")
    private Pessoa pessoa;

    @ManyToMany
    @JsonIgnoreProperties("locacoes")
    private List<Avaria> avarias;

    public Locacao(Veiculo vehicle, Pessoa pessoa, List<Avaria> avarias) {
        this.vehicle = vehicle;
        this.pessoa = pessoa;
        this.avarias = avarias;
    }

    public Locacao() {
        avarias = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVehicle() {
        return vehicle;
    }

    public void setVehicle(Veiculo vehicle) {
        this.vehicle = vehicle;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Avaria> getAvarias() {
        return avarias;
    }

    public void setAvarias(List<Avaria> avarias) {
        this.avarias = avarias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Locacao locacao = (Locacao) o;
        return Objects.equals(id, locacao.id) &&
                Objects.equals(vehicle, locacao.vehicle) &&
                Objects.equals(pessoa, locacao.pessoa) &&
                Objects.equals(avarias, locacao.avarias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicle, pessoa, avarias);
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", pessoa=" + pessoa +
                ", avarias=" + avarias +
                '}';
    }

}
