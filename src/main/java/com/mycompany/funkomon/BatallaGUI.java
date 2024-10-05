package com.mycompany.funkomon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BatallaGUI extends JFrame {

    private Pokemon usuarioPokemon;
    private Pokemon oponente;
    private JTextArea textArea;
    private JButton btnAtacar1, btnAtacar2, btnAtacar3, btnAtacar4;

    public BatallaGUI(Pokemon usuarioPokemon, Pokemon oponente) {
        this.usuarioPokemon = usuarioPokemon;
        this.oponente = oponente;
        setTitle("Batalla Pokémon");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        add(panel, BorderLayout.SOUTH);

        btnAtacar1 = new JButton("Ataque 1");
        btnAtacar2 = new JButton("Ataque 2");
        btnAtacar3 = new JButton("Ataque 3");
        btnAtacar4 = new JButton("Ataque 4");

        panel.add(btnAtacar1);
        panel.add(btnAtacar2);
        panel.add(btnAtacar3);
        panel.add(btnAtacar4);

        btnAtacar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(usuarioPokemon, 1);
            }
        });

        btnAtacar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(usuarioPokemon, 2);
            }
        });

        btnAtacar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(usuarioPokemon, 3);
            }
        });

        btnAtacar4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(usuarioPokemon, 4);
            }
        });

        actualizarEstado();
    }

    private void realizarAtaque(Pokemon atacante, int ataqueSeleccionado) {
        if (oponente.getVida() <= 0) {
            textArea.append(oponente.getNombre() + " ya ha sido derrotado!\n");
            return;
        }

        int danio = 0;

        switch (ataqueSeleccionado) {
            case 1:
                if (atacante instanceof Charmander) {
                    ((Charmander) atacante).atacarMordisco(oponente);
                } else if (atacante instanceof Squirtle) {
                    ((Squirtle) atacante).atacarPistolaAgua(oponente);
                } else if (atacante instanceof Gengar) {
                    ((Gengar) atacante).atacarBolaSombra(oponente);
                } else if (atacante instanceof Magmar) {
                    ((Magmar) atacante).atacarLlamarada(oponente);
                }
                break;
            case 2:
                if (atacante instanceof Charmander) {
                    ((Charmander) atacante).atacarLanzallamas(oponente);
                } else if (atacante instanceof Squirtle) {
                    ((Squirtle) atacante).atacarHidrobomba(oponente);
                } else if (atacante instanceof Gengar) {
                    ((Gengar) atacante).atacarPuñoSombra(oponente);
                } else if (atacante instanceof Magmar) {
                    ((Magmar) atacante).atacarPunioFuego(oponente);
                }
                break;
            case 3:
                if (atacante instanceof Charmander) {
                    ((Charmander) atacante).atacarGruñido(oponente);
                } else if (atacante instanceof Squirtle) {
                    ((Squirtle) atacante).atacarHidrobomba(oponente);
                } else if (atacante instanceof Gengar) {
                    ((Gengar) atacante).atacarTinieblas(oponente);
                } else if (atacante instanceof Magmar) {
                    ((Magmar) atacante).atacarLanzallamas(oponente);
                }
                break;
            case 4:
                // Añadir un ataque adicional o una acción especial
                break;
            default:
                textArea.append("Ataque no válido!\n");
                return;
        }

        // Actualiza la vida del oponente y muestra el resultado
        if (oponente.getVida() <= 0) {
            textArea.append(oponente.getNombre() + " ha sido derrotado!\n");
            return;
        }

        // Ataque del oponente (simplificado)
        int danioOponente = 10; // Establece el daño del oponente
        textArea.append(oponente.getNombre() + " ataca a " + usuarioPokemon.getNombre() + " causando " + danioOponente + " de daño.\n");
        usuarioPokemon.recibirDanio(danioOponente);

        if (usuarioPokemon.getVida() <= 0) {
            textArea.append(usuarioPokemon.getNombre() + " ha sido derrotado!\n");
        }

        // Mensaje de ataque del usuario
        textArea.append(usuarioPokemon.getNombre() + " ataca a " + oponente.getNombre() + " causando " + danio + " de daño.\n");
        oponente.recibirDanio(danio);

        actualizarEstado();
    }

    private void actualizarEstado() {
        textArea.append(usuarioPokemon + "\n");
        textArea.append(oponente + "\n");
    }
}