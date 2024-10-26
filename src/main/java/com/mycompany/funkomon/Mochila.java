package com.mycompany.funkomon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mochila {
    private Connection connection;

    public Mochila() {
        try {

            String url = "jdbc:mysql://localhost:3306/funkomon";
            String user = "root";
            String password = "emerson23";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarItem(int iditem, String itemNombre, int cantidad) {
        String sqlSelect = "SELECT item_cantidad FROM mochila WHERE item_nombre = ?";
        String sqlInsert = "INSERT INTO mochila (iditem, item_nombre, item_cantidad) VALUES (?, ?)";
        String sqlUpdate = "UPDATE mochila SET item_cantidad = item_cantidad + ? WHERE item_nombre = ?";
        
        try (PreparedStatement pstmtSelect = connection.prepareStatement(sqlSelect)) {
            pstmtSelect.setString(1, itemNombre);
            ResultSet rs = pstmtSelect.executeQuery();

            if (rs.next()) {
         
                try (PreparedStatement pstmtUpdate = connection.prepareStatement(sqlUpdate)) {
                    pstmtUpdate.setInt(1, cantidad);
                    pstmtUpdate.setString(2, itemNombre);
                    pstmtUpdate.executeUpdate();
                    System.out.println(cantidad + " " + itemNombre + "(s) añadidos a la mochila.");
                }
            } else {
    
                try (PreparedStatement pstmtInsert = connection.prepareStatement(sqlInsert)) {
                    pstmtInsert.setString(1, itemNombre);
                    pstmtInsert.setInt(2, cantidad);
                    pstmtInsert.executeUpdate();
                    System.out.println(itemNombre + " añadido a la mochila con cantidad: " + cantidad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void usarItem(String itemNombre) {
        String sqlSelect = "SELECT item_cantidad FROM mochila WHERE item_nombre = ?";
        String sqlDelete = "DELETE FROM mochila WHERE item_nombre = ?";
        String sqlUpdate = "UPDATE mochila SET item_cantidad = item_cantidad - 1 WHERE item_nombre = ?";
        
        try (PreparedStatement pstmtSelect = connection.prepareStatement(sqlSelect)) {
            pstmtSelect.setString(1, itemNombre);
            ResultSet rs = pstmtSelect.executeQuery();

            if (rs.next()) {
                int cantidadActual = rs.getInt("item_cantidad");

                if (cantidadActual > 1) {
                    try (PreparedStatement pstmtUpdate = connection.prepareStatement(sqlUpdate)) {
                        pstmtUpdate.setString(1, itemNombre);
                        pstmtUpdate.executeUpdate();
                        System.out.println("Usaste " + itemNombre + ". Quedan " + (cantidadActual - 1) + ".");
                    }
                } else {
                    try (PreparedStatement pstmtDelete = connection.prepareStatement(sqlDelete)) {
                        pstmtDelete.setString(1, itemNombre);
                        pstmtDelete.executeUpdate();
                        System.out.println("Usaste el último " + itemNombre + ".");
                    }
                }
            } else {
                System.out.println("El ítem " + itemNombre + " no está disponible.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   //Metodo para mostrat lo que hay en la mochila//
    public void mostrarItems() {
        String sql = "SELECT * FROM mochila";
        List<String> items = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String itemNombre = rs.getString("item_nombre");
                int cantidad = rs.getInt("item_cantidad");
                items.add(itemNombre + " (Cantidad: " + cantidad + ")");
            }

            if (items.isEmpty()) {
                System.out.println("La mochila está vacía.");
            } else {
                System.out.println("Ítems en la mochila:");
                for (String item : items) {
                    System.out.println("- " + item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para verificar si un ítem está disponible en la mochila
    public boolean tieneItem(String itemNombre) {
        String sql = "SELECT COUNT(*) AS count FROM mochila WHERE item_nombre = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, itemNombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt("count") > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
