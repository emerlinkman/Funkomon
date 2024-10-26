package com.mycompany.funkomon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Entrenador extends JFrame {
    public Entrenador() {
        // Configuración de la ventana Entrenador
        setTitle("Entrenador");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Crear panel principal con borde vacío para dar un margen alrededor del contenido
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 255), 1)); // Borde azul claro

        // Crear panel para la información del entrenador
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir un margen interno
        panelInfo.setBackground(Color.WHITE);

        // Etiquetas de información del entrenador
        JLabel titulo = new JLabel("Bienvenido Entrenador", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nombre = new JLabel("Nombre: Ash Ketchum");
        JLabel edad = new JLabel("Edad: 10 años");
        JLabel sexo = new JLabel("Sexo: Masculino");
        JLabel region = new JLabel("Región: Pueblo Paleta, Kanto");
        JLabel pokedolar = new JLabel("Pokedolar: 1000");
        JLabel medallas = new JLabel("Medallas Ganadas: 8");

        // Añadir las etiquetas al panel
        panelInfo.add(titulo);
        panelInfo.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre líneas
        panelInfo.add(nombre);
        panelInfo.add(edad);
        panelInfo.add(sexo);
        panelInfo.add(region);
        panelInfo.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre secciones
        panelInfo.add(pokedolar);
        panelInfo.add(medallas);

        // Crear panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnMochila = new JButton("Mochila");
        JButton btnPokedex = new JButton("Equipo pokemon");

        // Añadir botones al panel de botones
        panelBotones.add(btnMochila);
        panelBotones.add(btnPokedex);

        // Añadir los paneles al panel principal
        panelPrincipal.add(panelInfo, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Añadir el panel principal a la ventana
        add(panelPrincipal);
        pack(); // Ajusta la ventana al contenido

        // Acción al presionar el botón "Mochila"
        btnMochila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mochila mochila = new Mochila(); // Crea la instancia de Mochila
                mochila.mostrarItems(); // Muestra los ítems
                mochila.cerrarConexion(); // Cierra la conexión cuando termina
            }
        });
    }
}
