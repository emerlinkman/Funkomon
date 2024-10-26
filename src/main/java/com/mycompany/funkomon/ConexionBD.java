/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kev98
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static String url = "jdbc:mysql://127.0.0.1:3306/Pokedex";
    private static String user = "root";
    private static String password = "kevin";

    public static void main(String[] args) { 
        try {
            Connection conn = getConnection();
            System.out.println("Conexión exitosa a la base de datos Pokedex!");
            conn.close(); // Cerrar la conexión al final
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
