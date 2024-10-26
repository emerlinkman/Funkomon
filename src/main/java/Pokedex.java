/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kev98
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pokedex {
    public static String obtenerPokedex() {
        StringBuilder pokedexData = new StringBuilder();
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre, tipo FROM pokedex")) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                pokedexData.append("Nombre: ").append(nombre).append(", Tipo: ").append(tipo).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al obtener la Pokedex.";
        }
        return pokedexData.toString();
    }
}