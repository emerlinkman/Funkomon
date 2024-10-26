package com.mycompany.funkomon;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BatallaGUI extends JFrame {

    private Pokemon entrenador;
    private final Pokemon oponente;
    private final JTextArea textArea;
    private final JButton btnAtacar1;
    private final JButton btnAtacar2;
    private final JButton btnAtacar3;
    private final JButton btnAtacar4;
    private final JButton btnSalir;
    private final JButton btnReiniciar;
    private final JButton btnAtacarOponente; // Botón para que el oponente ataque
    private final Random random = new Random();

    public BatallaGUI(Pokemon usuarioPokemon, Pokemon oponente) {
        this.entrenador = usuarioPokemon;
        this.oponente = oponente;

        setTitle("Batalla Pokémon");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Agregar el GIF en el centro
        ImageIcon gifIcon = new ImageIcon("C:\\Users\\kev98\\OneDrive\\Imágenes\\batalla pokemon.gif");
        JLabel gifLabel = new JLabel(gifIcon);
        add(gifLabel, BorderLayout.CENTER);

        // Crear el área de texto
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.NORTH);

        // Crear el panel de botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        add(panel, BorderLayout.SOUTH);

        // Inicializar botones de ataque
        btnAtacar1 = new JButton("Ataque 1");
        btnAtacar2 = new JButton("Ataque 2");
        btnAtacar3 = new JButton("Ataque 3");
        btnAtacar4 = new JButton("Ataque 4");

        panel.add(btnAtacar1);
        panel.add(btnAtacar2);
        panel.add(btnAtacar3);
        panel.add(btnAtacar4);

        // Botones de salir y reiniciar
        btnSalir = new JButton("Salir");
        btnReiniciar = new JButton("Volver a pelear");
        btnAtacarOponente = new JButton("Ataque del Oponente"); // Nuevo botón para el ataque del oponente
        btnAtacarOponente.setEnabled(false); // Deshabilitar inicialmente
        panel.add(btnReiniciar);
        panel.add(btnSalir);
        panel.add(btnAtacarOponente); // Añadir botón al panel

        // Configura los listeners para los botones de ataque
        btnAtacar1.addActionListener(e -> realizarAtaque(entrenador, 1));
        btnAtacar2.addActionListener(e -> realizarAtaque(entrenador, 2));
        btnAtacar3.addActionListener(e -> realizarAtaque(entrenador, 3));
        
        btnAtacar4.addActionListener(e -> realizarAtaque(entrenador, 4));

        // Configura los listeners para los botones de salir y reiniciar
        btnSalir.addActionListener(e -> System.exit(0));
        btnReiniciar.addActionListener(e -> reiniciarBatalla());

        // Configura el listener para el ataque del oponente
        btnAtacarOponente.addActionListener(e -> realizarAtaqueOponente());

        // Actualiza los nombres de los botones según el Pokémon
        actualizarBotonesAtaque(usuarioPokemon);
        actualizarEstado(); // Muestra el estado inicial
    }

    private void realizarAtaque(Pokemon atacante, int ataqueSeleccionado) {
        if (oponente.getVida() <= 0) {
            textArea.append(oponente.getNombre() + " ya ha sido derrotado!\n");
            return;
        }

        int danio = calcularDanio(atacante, ataqueSeleccionado);
        String ataqueRealizado = obtenerNombreAtaque(atacante, ataqueSeleccionado);

        if (danio > 0) {
            textArea.append(atacante.getNombre() + " usó " + ataqueRealizado + " y causó " + danio + " de daño a " + oponente.getNombre() + ".\n");
            oponente.recibirDanio(danio);
        }

        if (oponente.getVida() <= 0) {
            textArea.append(oponente.getNombre() + " ha sido derrotado!\n");
            return;
        }

        // Habilitar el botón de ataque del oponente
        btnAtacarOponente.setEnabled(true);
    }

    private int calcularDanio(Pokemon atacante, int ataqueSeleccionado) {
        switch (ataqueSeleccionado) {
            case 1: return 15;
            case 2: return 35;
            case 3: return 0;  
            case 4: return 25;
            default: return 0;
        }
    }

    private String obtenerNombreAtaque(Pokemon atacante, int ataqueSeleccionado) {
        return switch (ataqueSeleccionado) {
            case 1 -> atacante instanceof Charmander ? "Mordisco" : "Placaje";
            case 2 -> atacante instanceof Charmander ? "Lanzallamas" : "Pistola de Agua";
            case 3 -> "Gruñido";
            case 4 -> atacante instanceof Charmander ? "Puño Fuego" : "Surf";
            default -> "Ataque no válido";
        };
    }

    private void realizarAtaqueOponente() {
        int ataqueSeleccionadoOponente = random.nextInt(4) + 1;  // Selecciona un ataque aleatorio del oponente
        realizarAtaque(oponente, ataqueSeleccionadoOponente);
        // Deshabilitar el botón de ataque del oponente después de que ataque
        btnAtacarOponente.setEnabled(false);
        actualizarEstado(); // Actualizar el estado después del ataque
    }

    private void actualizarBotonesAtaque(Pokemon usuarioPokemon) {
        if (usuarioPokemon instanceof Charmander) {
            btnAtacar1.setText("Mordisco");
            btnAtacar2.setText("Lanzallamas");
            btnAtacar3.setText("Gruñido");
            btnAtacar4.setText("Puño Fuego");
        } else if (usuarioPokemon instanceof Squirtle) {
            btnAtacar1.setText("Placaje");
            btnAtacar2.setText("Pistola de Agua");
            btnAtacar3.setText("Surf");
            btnAtacar4.setText("Hidrobomba");
        } else if (usuarioPokemon instanceof Gengar) {
            btnAtacar1.setText("Placaje");
            btnAtacar2.setText("Mordisco");
            btnAtacar3.setText("Bola Sombra");
            btnAtacar4.setText("Puño Sombra");
        } else if (usuarioPokemon instanceof Venusaur) {
            btnAtacar1.setText("Placaje");
            btnAtacar2.setText("Látigo Cepa");
            btnAtacar3.setText("Somnífero");
            btnAtacar4.setText("Gigadrenado");
        }
    }

    private void actualizarEstado() {
        textArea.append("\nEstado Actual:\n");
        textArea.append(entrenador.getNombre() + " - Vida: " + entrenador.getVida() + "\n");
        textArea.append(oponente.getNombre() + " - Vida: " + oponente.getVida() + "\n");
        textArea.append("-------------------------\n");
    }

    private void reiniciarBatalla() {
        entrenador.setVida(100);
        oponente.setVida(100);
        textArea.setText("");
        actualizarEstado();
        // Deshabilitar el botón de ataque del oponente
        btnAtacarOponente.setEnabled(false);
    }
}