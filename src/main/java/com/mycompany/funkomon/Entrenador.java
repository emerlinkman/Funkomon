/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kev98
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Clase para el panel con imagen de fondo
class MenuConImagenFondo2 extends JPanel {
    private final Image fondo;

    public MenuConImagenFondo2() {
        // Cargar la imagen de fondo
        fondo = new ImageIcon("C:\\Users\\kev98\\OneDrive\\Imágenes\\pokemon.jpg").getImage(); // Cambia esta ruta por la ubicación de tu imagen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
}

public class Entrenador extends JFrame {
    public Entrenador() {
        // Configuración de la ventana Entrenador
        setTitle("Entrenador");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Crear el panel con imagen de fondo
        MenuConImagenFondo2 panelFondo = new MenuConImagenFondo2();
        panelFondo.setLayout(new BorderLayout());

        // Crear panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 255), 1)); // Borde azul claro

        // Crear panel para la información del entrenador
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(0, 2)); // Crear un GridLayout para la tabla
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir un margen interno
        panelInfo.setBackground(new Color(255, 255, 255, 220)); // Fondo blanco con algo de transparencia

        // Etiquetas de información del entrenador
        JLabel titulo = new JLabel("Bienvenido Entrenador", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24)); // Título en negrita y más grande
        titulo.setForeground(Color.BLUE); // Cambiar el color del texto

        // Crear las etiquetas con la información
        JLabel nombre = new JLabel("Nombre: Ash Ketchum");
        JLabel edad = new JLabel("Edad: 12 años");
        JLabel sexo = new JLabel("Sexo: Masculino");
        JLabel region = new JLabel("Región: Pueblo Paleta, Kanto");
        JLabel pokedolar = new JLabel("Pokedolar: 1000");
        JLabel medallas = new JLabel("Medallas Ganadas: 8");
        JLabel pokemonVistos = new JLabel("Pokemon Vistos: 151");
        JLabel pokemonAtrapados = new JLabel("Pokemon Atrapados: 120");

        // Añadir las etiquetas al panel de información
        panelInfo.add(titulo);
        panelInfo.add(new JLabel()); // Espacio vacío en la tabla
        panelInfo.add(nombre);
        panelInfo.add(edad);
        panelInfo.add(sexo);
        panelInfo.add(region);
        panelInfo.add(pokedolar);
        panelInfo.add(medallas);
        panelInfo.add(pokemonVistos);
        panelInfo.add(pokemonAtrapados);

        // Crear panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnMochila = new JButton("Mochila");
        JButton btnEquipoPokemon = new JButton("Equipo Pokémon");

        // Añadir botones al panel de botones
        panelBotones.add(btnMochila);
        panelBotones.add(btnEquipoPokemon);

        // Añadir los paneles al panel principal
        panelPrincipal.add(panelInfo, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Añadir el panel principal al panel con imagen de fondo
        panelFondo.add(panelPrincipal);

        // Añadir el panel con imagen de fondo a la ventana
        setContentPane(panelFondo);
        pack(); // Ajusta la ventana al contenido

        // Acción al presionar el botón "Mochila"
        btnMochila.addActionListener((ActionEvent e) -> {
            mostrarMochila();
        });

        // Acción al presionar el botón "Equipo Pokémon"
        btnEquipoPokemon.addActionListener((ActionEvent e) -> {
            mostrarEquipoPokemon();
        });
    }

    // Método para mostrar la mochila en un nuevo JFrame
   private void mostrarMochila() {
    JFrame ventanaMochila = new JFrame("Mochila");
    ventanaMochila.setSize(400, 300);
    ventanaMochila.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaMochila.setLocationRelativeTo(null); // Centra la ventana

    JTextArea textAreaMochila = new JTextArea();
    textAreaMochila.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textAreaMochila);
    ventanaMochila.add(scrollPane, BorderLayout.CENTER);

    // Obtener los ítems de la mochila desde la base de datos
    List<String> items = Mochila.obtenerItemsMochila();
    StringBuilder contenido = new StringBuilder();

    if (items != null) {
        for (String item : items) {
            contenido.append(item).append("\n");
        }
    } else {
        contenido.append("Error al obtener los ítems de la mochila.");
    }
    
    textAreaMochila.setText(contenido.toString());
    ventanaMochila.setVisible(true);
}


    // Método para mostrar el equipo Pokémon en un nuevo JFrame
    private void mostrarEquipoPokemon() {
        JFrame ventanaEquipo = new JFrame("Equipo Pokémon");
        ventanaEquipo.setSize(400, 300);
        ventanaEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaEquipo.setLocationRelativeTo(null); // Centra la ventana

        JTextArea textAreaEquipo = new JTextArea();
        textAreaEquipo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaEquipo);
        ventanaEquipo.add(scrollPane, BorderLayout.CENTER);

        // Obtener el equipo Pokémon desde la base de datos
        List<String> equipoPokemon = obtenerEquipoPokemon();
        StringBuilder contenido = new StringBuilder();
        for (String pokemon : equipoPokemon) {
            contenido.append(pokemon).append("\n");
        }
        textAreaEquipo.setText(contenido.toString());

        ventanaEquipo.setVisible(true);
    }

    // Método para obtener los ítems de la mochila desde la base de datos
    private List<String> obtenerItemsMochila() {
        List<String> items = new ArrayList<>();
        String sql = "SELECT item_name FROM mochila"; // Consulta para obtener los ítems de la mochila

        try (Connection connection = ConexionBD.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                items.add(rs.getString("item_name")); // Suponiendo que la columna se llama "item_name"
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
        }

        return items; // Devuelve la lista de ítems
    }

    // Método para obtener el equipo Pokémon desde la base de datos
    private List<String> obtenerEquipoPokemon() {
        List<String> equipo = new ArrayList<>(); // Inicializa la lista para evitar NullPointerException
        String sql = "SELECT Nombre, Tipo, Ataque1, Ataque2, Ataque3, Ataque4, Nivel FROM equipo_pokemon"; // Consulta para obtener los detalles del equipo Pokémon

        try (Connection connection = ConexionBD.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Obtener los datos de cada columna
                String nombrePokemon = rs.getString("Nombre");
                String tipo = rs.getString("Tipo");
                String ataque1 = rs.getString("Ataque1");
                String ataque2 = rs.getString("Ataque2");
                String ataque3 = rs.getString("Ataque3");
                String ataque4 = rs.getString("Ataque4");
                int nivel = rs.getInt("Nivel");

                // Formatear la información del Pokémon
                String detallesPokemon = String.format(
                    "Nombre: %s\nTipo: %s\nAtaques: %s, %s, %s, %s\nNivel: %d\n",
                    nombrePokemon, tipo, ataque1, ataque2, ataque3, ataque4, nivel
                );

                // Añadir la información formateada a la lista
                equipo.add(detallesPokemon);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
        }

        return equipo; // Devuelve la lista con los detalles de los Pokémon
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Entrenador().setVisible(true);
        });
    }
}