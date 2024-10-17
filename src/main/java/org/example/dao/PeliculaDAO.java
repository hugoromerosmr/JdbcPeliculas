package org.example.dao;

import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula> {
    private Connection con;

    public PeliculaDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<Pelicula> findAll() {
        return List.of();
    }

    @Override
    public Pelicula findById(Integer id) {
        return null;
    }

    /*MÉTODO PARA AÑADIR PELICULAS*/
    @Override
    public void save(Pelicula pelicula) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO pelicula (titulo, año, genero) VALUES (?,?,?)")) {
            ps.setString(1, pelicula.getTitulo());
            ps.setInt(2, pelicula.getAno());
            ps.setString(3, pelicula.getGenero());
            ps.executeUpdate();
            System.out.println("Pelicula Añadida");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*MÉTODO PARA FILTRAR PELICULAS POR GÉNERO*/

    public List<Pelicula> filtrarPeliculas(String genero) {
        var peliculas = new ArrayList<Pelicula>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pelicula WHERE genero=?")) {
            ps.setString(1, genero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                peliculas.add(new Pelicula(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return peliculas;
    }

    /*MÉTODO PARA CONTAR EL NÚMERO DE PELICULAS*/

    public int contarPeliculas() {
        int contador = 0;
        try (PreparedStatement ps = con.prepareStatement("select count(id) from pelicula;")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                contador = rs.getInt(1);
                System.out.println("Hay "+contador+" peliculas");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contador;
    }


    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void delete(int id) {

    }

}
