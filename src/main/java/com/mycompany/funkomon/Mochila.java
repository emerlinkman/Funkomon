import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Mochila {
    public static List<String> obtenerItemsMochila() {
        List<String> items = new ArrayList<>();
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Nombre_item, Cantidad_items FROM mochila")) { // Asegúrate de que estos nombres coincidan con tu esquema

            while (rs.next()) {
                String nombreItem = rs.getString("Nombre_item");
                int cantidadItems = rs.getInt("Cantidad_items");
                items.add(nombreItem + " (Cantidad: " + cantidadItems + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Indica error
        }
        return items;
    }
}
