package com.mycompany.funkomon;

/**
 *
 * @author kev98
 */
public class Squirtle extends Pokemon implements IAgua{

    public Squirtle() {
        super(007, "Squirtle", "Agua", "Agua Dulce", "Kanto", 100, 40);
    }

    public Squirtle(int numPokedex, String nombre, String tipo, String habitat, String region, int vida, int ataque) {
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
    public void atacarPistolaAgua(Pokemon objetivo) {
        int danio = 20;
        System.out.println(getNombre() + " ha atacado con Pistola de Agua");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarHidrobomba(Pokemon objetivo) {
        int danio = 50;
        System.out.println(getNombre() + " ha atacado con Hidrobomba");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarSurf(Pokemon objetivo) {
        int danio = 35;
        System.out.println(getNombre() + " ha atacado con Surf");
        atacar(objetivo, danio);
    }
}