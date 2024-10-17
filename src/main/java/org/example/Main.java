package org.example;

import org.example.dao.JdbcUtils;
import org.example.dao.PeliculaDAO;
import org.example.model.Pelicula;


public class Main {
    public static void main(String[] args) {
        /*Pelicula peli= new Pelicula("La rata de Javi",2015,"comedia");
        new PeliculaDAO(JdbcUtils.getConnection()).save(peli);

        new PeliculaDAO(JdbcUtils.getConnection()).contarPeliculas();

        /*new PeliculaDAO(JdbcUtils.getConnection()).filtrarPeliculas("comedia").forEach(System.out::println);*/

    }
}