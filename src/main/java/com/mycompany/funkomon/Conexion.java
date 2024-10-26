package com.mycompany.funkomon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/funkomon";
    private String user = "root";
    private String ps = "emerson23";

    public Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, ps);
            // System.out.println("Conexion Exitosa"); // Puedes descomentar esto para ver el mensaje
        } catch (SQLException e) {
            System.out.println("Error en conexion: " + e.getMessage());
        }
        return conexion;
    }
}

