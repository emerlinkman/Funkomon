package com.mycompany.funkomon;

public class Gengar extends Pokemon implements IFantasma {

    public Gengar() {
        super(94, "Gengar", "Fantasma/Veneno", "Cueva", "Kanto", 150, 100);
    }

    public Gengar(int numPokedex, String nombre, String tipo, String habitat, String region, int vida, int ataque) {
        super(numPokedex, nombre, tipo, habitat, region, vida, ataque);
    }

    @Override
    protected void atacarPlacaje(Pokemon objetivo) {
        int danio = 10;
        System.out.println(getNombre() + " ha atacado con Placaje");
        atacar(objetivo, danio);
    }

    @Override
    protected void atacarMordisco(Pokemon objetivo) {
        int danio = 15;
        System.out.println(getNombre() + " ha atacado con Mordisco");
        atacar(objetivo, danio);
    }

    @Override
    protected void atacarGruñido(Pokemon objetivo) {
        int danio = 0;
        System.out.println(getNombre() + " ha atacado con Gruñido");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarBolaSombra(Pokemon objetivo) {
        int danio = 50;
        System.out.println(getNombre() + " ha atacado con Bola Sombra");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarPuñoSombra(Pokemon objetivo) {
        int danio = 75;
        System.out.println(getNombre() + " ha atacado con Puño Sombra");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarTinieblas(Pokemon objetivo) {
        int danio = 35;
        System.out.println(getNombre() + " ha atacado con Tinieblas");
        atacar(objetivo, danio);
    }
}
