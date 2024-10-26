
import javax.swing.*;
import java.awt.*;

public class Funkomon extends JFrame {

    public Funkomon() {
        // Configuración de la ventana principal
        setTitle("Pokémon");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear y configurar el panel de fondo
        MenuConImagenFondo panelFondo = new MenuConImagenFondo();
        panelFondo.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelFondo.setOpaque(false);

        // Crear el título
        JLabel titulo = new JLabel("Pokémon", JLabel.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 48));
        titulo.setForeground(Color.WHITE);
        panelFondo.add(titulo);

        // Crear los botones personalizados
        BotonPersonalizado btnEntrenador = crearBoton("Entrenador", e -> mostrarVentanaEntrenador());
        BotonPersonalizado btnPokedex = crearBoton("Pokedex", e -> mostrarPokedex());
        BotonPersonalizado btnBatalla = crearBoton("Batalla Pokémon", e -> iniciarBatalla());
        BotonPersonalizado btnSalir = crearBoton("Salir", e -> System.exit(0));

        // Añadir los botones al panel de fondo
        panelFondo.add(btnEntrenador);
        panelFondo.add(btnPokedex);
        panelFondo.add(btnBatalla);
        panelFondo.add(btnSalir);

        // Añadir el panel de fondo con los botones al frame principal
        add(panelFondo, BorderLayout.CENTER);
    }

    // Método para crear un botón personalizado con acción
    private BotonPersonalizado crearBoton(String texto, java.awt.event.ActionListener accion) {
        BotonPersonalizado boton = new BotonPersonalizado(texto);
        boton.addActionListener(accion);
        return boton;
    }

    // Método para mostrar la ventana del Entrenador
    private void mostrarVentanaEntrenador() {
        Entrenador ventanaEntrenador = new Entrenador();
        ventanaEntrenador.setVisible(true);
    }

    // Método para mostrar la Pokedex
    private void mostrarPokedex() {
    String pokedexInfo = Pokedex.obtenerPokedex();

    // Crear un JTextArea para mostrar la información
    JTextArea textArea = new JTextArea();
    textArea.setEditable(false);
    textArea.setText(pokedexInfo);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    // Crear un JScrollPane para permitir el desplazamiento
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(600, 400)); // Tamaño preferido del JScrollPane

    // Mostrar la Pokedex en un JFrame
    JFrame ventanaPokedex = new JFrame("Pokedex");
    ventanaPokedex.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaPokedex.add(scrollPane);
    ventanaPokedex.pack();
    ventanaPokedex.setLocationRelativeTo(null); // Centrar la ventana
    ventanaPokedex.setVisible(true);
}


    // Método para iniciar la batalla Pokémon
    private void iniciarBatalla() {
        Pokemon jugador = seleccionarPokemon();
        Pokemon oponente = seleccionarPokemon();
        
        // Verifica que el oponente no sea el mismo que el jugador
        while (jugador.getClass() == oponente.getClass()) {
            oponente = seleccionarPokemon();
        }
        
        BatallaGUI batallaGUI = new BatallaGUI(jugador, oponente);
        batallaGUI.setVisible(true);
        this.setVisible(false); // Ocultar el menú principal
    }

    // Método para seleccionar un Pokémon
    private Pokemon seleccionarPokemon() {
        Object[] opciones = {"Charmander", "Squirtle", "Gengar", "Venusaur"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona tu Pokémon:",
                "Seleccionar Pokemon para la batalla",
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
        return new Charmander();
    }

    public static void main(String[] args) {
        // Ejecuta el menú principal
        SwingUtilities.invokeLater(() -> {
            new Funkomon().setVisible(true);
        });
    }
}


class MenuConImagenFondo extends JPanel {
    private final Image fondo;

    public MenuConImagenFondo() {
        
        fondo = new ImageIcon("C:\\Users\\kev98\\OneDrive\\Imágenes\\pokemon.jpg").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
}


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
