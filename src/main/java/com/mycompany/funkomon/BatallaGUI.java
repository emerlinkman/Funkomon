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

        // Obtener los nombres de los ataques desde el Pokémon del usuario
        String[] ataques = usuarioPokemon.getAtaques();

        // Crear los botones con los nombres de los ataques
        btnAtacar1 = new JButton(ataques[0]);
        btnAtacar2 = new JButton(ataques[1]);
        btnAtacar3 = new JButton(ataques[2]);
        btnAtacar4 = new JButton(ataques[3]);

        // Agregar botones al panel
        panel.add(btnAtacar1);
        panel.add(btnAtacar2);
        panel.add(btnAtacar3);
        panel.add(btnAtacar4);

        // Asignar acciones a los botones
        btnAtacar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(usuarioPokemon, 0); // Ataque en posición 0
            }
        });

        btnAtacar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(usuarioPokemon, 1); // Ataque en posición 1
            }
        });

        btnAtacar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(usuarioPokemon, 2); // Ataque en posición 2
            }
        });

        btnAtacar4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaque(usuarioPokemon, 3); // Ataque en posición 3
            }
        });

        actualizarEstado();
    }

    private void realizarAtaque(Pokemon atacante, int indiceAtaque) {
        if (oponente.getVida() <= 0) {
            textArea.append(oponente.getNombre() + " ya ha sido derrotado!\n");
            return;
        }

        // Realiza el ataque
        String ataqueUsado = atacante.getAtaques()[indiceAtaque];
        int danio = atacante.usarAtaque(indiceAtaque, oponente);  // Se llama al ataque en la clase Pokémon
        textArea.append(atacante.getNombre() + " usó " + ataqueUsado + " causando " + danio + " de daño.\n");

        // Verificar si el oponente fue derrotado
        if (oponente.getVida() <= 0) {
            textArea.append(oponente.getNombre() + " ha sido derrotado!\n");
            return;
        }

        // Contraataque del oponente (simplificado)
        int danioOponente = 10;  // Ejemplo de daño del oponente
        textArea.append(oponente.getNombre() + " ataca a " + atacante.getNombre() + " causando " + danioOponente + " de daño.\n");
        atacante.recibirDanio(danioOponente);

        if (atacante.getVida() <= 0) {
            textArea.append(atacante.getNombre() + " ha sido derrotado!\n");
        }

        actualizarEstado();
    }

    private void actualizarEstado() {
        textArea.append(usuarioPokemon + "\n");
        textArea.append(oponente + "\n");
    }
}
