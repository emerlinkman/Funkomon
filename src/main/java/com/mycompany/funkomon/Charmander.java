package com.mycompany.funkomon;

public class Charmander extends Pokemon implements IFuego {

    public Charmander() {
        super(004, "Charmander", "Fuego", "Montaña", "Kanto", 100, 50);
    }

    public Charmander(int numPokedex, String nombre, String tipo, String habitat, String region, int vida, int ataque) {
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
    public void atacarLanzallamas(Pokemon objetivo) {
        int danio = 35;
        System.out.println(getNombre() + " ha atacado con Lanzallamas");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarLlamarada(Pokemon objetivo) {
        int danio = 50;
        System.out.println(getNombre() + " ha atacado con Llamarada");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarPunioFuego(Pokemon objetivo) {
        int danio = 25;
        System.out.println(getNombre() + " ha atacado con Puño Fuego");
        atacar(objetivo, danio);
    }
}