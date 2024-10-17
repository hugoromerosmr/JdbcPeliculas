package org.example.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Pelicula implements Serializable {
    private int id;
    private String titulo;
    private int ano;
    private String genero;

    public Pelicula(int id, String titulo, int ano, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
    }

    public Pelicula(String titulo, int ano, String genero) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", ano=" + ano +
                '}';
    }
}
