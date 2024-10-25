package com.mycompany.funkomon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funkomon extends JFrame {

    public Funkomon() {
        // Configuración de la ventana principal
        setTitle("Pokémon");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para el fondo con imagen
        MenuConImagenFondo panelFondo = new MenuConImagenFondo();
        panelFondo.setLayout(new GridLayout(5, 1, 10, 10));
        panelFondo.setOpaque(false);

        // Crear el título
        JLabel titulo = new JLabel("Pokémon", JLabel.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 48));
        titulo.setForeground(Color.WHITE);
        panelFondo.add(titulo);

        // Crear los botones personalizados
        BotonPersonalizado btnEntrenador = new BotonPersonalizado("Entrenador");
        BotonPersonalizado btnPokedex = new BotonPersonalizado("Pokedex");
        BotonPersonalizado btnBatalla = new BotonPersonalizado("Batalla Pokémon");
        BotonPersonalizado btnSalir = new BotonPersonalizado("Salir");

        // Añadir acciones a los botones
        btnEntrenador.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Aquí va la información del Entrenador.");
        });

        btnPokedex.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Aquí se muestra la Pokedex.");
        });

        btnBatalla.addActionListener(e -> {
            Pokemon jugador = seleccionarPokemon();
            Pokemon oponente = seleccionarPokemon();  // Puedes cambiar la lógica de selección del oponente
            new BatallaGUI(jugador, oponente).setVisible(true);
        });

        btnSalir.addActionListener(e -> {
            System.exit(0);  // Cierra la aplicación
        });

        // Añadir los botones al panel de fondo
        panelFondo.add(btnEntrenador);
        panelFondo.add(btnPokedex);
        panelFondo.add(btnBatalla);
        panelFondo.add(btnSalir);

        // Añadir el panel de fondo con los botones al frame principal
        add(panelFondo, BorderLayout.CENTER);
    }

    // Método para seleccionar un Pokémon
    private Pokemon seleccionarPokemon() {
        Object[] opciones = {"Charmander", "Squirtle", "Gengar", "Venusaur"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona tu Pokémon:",
                "Seleccionar Pokémon",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                "Charmander");

        // Retornar el Pokémon seleccionado
        if (seleccion != null) {
            switch (seleccion) {
                case "Charmander":
                    return new Charmander();
                case "Squirtle":
                    return new Squirtle();
                case "Gengar":
                    return new Gengar();
                case "Venusaur":
                    return new Venusaur();
            }
        }
        return new Charmander();  // Retornar Charmander por defecto si no se selecciona nada
    }

    public static void main(String[] args) {
        // Ejecuta el menú principal
        SwingUtilities.invokeLater(() -> {
            new Funkomon().setVisible(true);
        });
    }
}

// Clase para el fondo con imagen
class MenuConImagenFondo extends JPanel {
    private Image fondo;

    public MenuConImagenFondo() {
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

// Clase para botones personalizados
class BotonPersonalizado extends JButton {

    public BotonPersonalizado(String texto) {
        super(texto);
        setFont(new Font("Arial", Font.BOLD, 20));
        setForeground(Color.YELLOW);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Colores para el gradiente
        Color colorInicio = new Color(200, 50, 50);
        Color colorFinal = new Color(150, 20, 20);

        // Dibujar el gradiente en el botón
        g2.setPaint(new GradientPaint(0, 0, colorInicio, 0, getHeight(), colorFinal));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Dibujar el borde del botón
        g2.setColor(Color.DARK_GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        super.paintComponent(g2);
        g2.dispose();
    }
}
