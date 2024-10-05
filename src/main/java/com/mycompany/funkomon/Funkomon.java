package com.mycompany.funkomon;

import java.util.Random;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Funkomon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Crear Pokémon
        Charmander charmander = new Charmander(004, "Charmander", "Fuego", "Montaña", "Kanto", 100, 50);
        Squirtle squirtle = new Squirtle(007, "Squirtle", "Agua", "Agua Dulce", "Kanto", 100, 40);
        Gengar gengar = new Gengar(94, "Gengar", "Fantasma", "Cueva", "Kanto", 150, 100);
        Magmar magmar = new Magmar(126, "Magmar", "Fuego", "Montaña", "Kanto", 150, 100);

        // Menú de selección
        System.out.println("Selecciona tu Pokémon:");
        System.out.println("1. Charmander");
        System.out.println("2. Squirtle");
        System.out.println("3. Gengar");
        System.out.println("4. Magmar");    
        System.out.print("Opción: ");
        int seleccion = scanner.nextInt();
        
        Pokemon usuarioPokemon;
        switch (seleccion) {
            case 1:
                usuarioPokemon = charmander;
                break;
            case 2:
                usuarioPokemon = squirtle;
                break;
            case 3:
                usuarioPokemon = gengar;
                break;
            case 4:
                usuarioPokemon = magmar;
                break;
            default:
                System.out.println("Opción no válida, se seleccionará Charmander por defecto.");
                usuarioPokemon = charmander;
                break;
        }

        // Seleccionar oponente aleatorio
        Pokemon[] pokemons = {charmander, squirtle, gengar, magmar};
        Pokemon oponente;
        do {
            oponente = pokemons[random.nextInt(pokemons.length)];
        } while (oponente == usuarioPokemon);

        System.out.println("Tu oponente es: " + oponente.getNombre());

        // Mostrar la interfaz gráfica para la batalla
        final Pokemon finalUsuarioPokemon = usuarioPokemon;
        final Pokemon finalOponente = oponente;
        SwingUtilities.invokeLater(() -> new BatallaGUI(finalUsuarioPokemon, finalOponente).setVisible(true));
    }
}