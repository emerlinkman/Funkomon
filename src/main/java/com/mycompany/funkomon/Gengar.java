package com.mycompany.funkomon;

public class Gengar extends Pokemon implements IFantasma {

    public Gengar() {
        super(94, "Gengar", "Fantasma/Veneno", "Cueva", "Kanto", 150, 100);
    }

    public Gengar(int numPokedex, String nombre, String tipo, String habitat, String region, int vida, int ataque) {
        super(numPokedex, nombre, tipo, habitat, region, vida, ataque);
    }

    @Override
    public void atacarPlacaje(Pokemon objetivo) {
        int danio = 25; // Daño de Placaje
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Placaje causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public void atacarBolaSombra(Pokemon objetivo) {
        int danio = 45; // Daño de Bola Sombra
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Bola Sombra causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public void atacarPuñoSombra(Pokemon objetivo) {
        int danio = 60; // Daño de Puño Sombra
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Puño Sombra causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public void atacarTinieblas(Pokemon objetivo) {
        int danio = 35; // Daño de Tinieblas
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Tinieblas causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public String[] getAtaques() {
        return new String[]{"Placaje", "Bola Sombra", "Puño Sombra", "Tinieblas"};
    }

    @Override
    protected int usarAtaqueEspecifico(int indiceAtaque, Pokemon oponente) {
        switch (indiceAtaque) {
            case 1: atacarBolaSombra(oponente); break;
            case 2: atacarPuñoSombra(oponente); break;
            case 3: atacarTinieblas(oponente); break;
            default: throw new IllegalArgumentException("Ataque no válido");
        }
        return oponente.getVida();
    }
}
