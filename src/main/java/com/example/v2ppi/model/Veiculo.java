
package com.example.v2ppi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String marca;

    private String modelo;

    @ManyToOne
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public Veiculo() {
        categoria = new Categoria();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) &&
                Objects.equals(marca, veiculo.marca) &&
                Objects.equals(modelo, veiculo.modelo) &&
                Objects.equals(categoria, veiculo.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, categoria);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
