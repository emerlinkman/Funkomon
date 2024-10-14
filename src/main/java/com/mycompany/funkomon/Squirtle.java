package com.mycompany.funkomon;

/**
 *
 * @author kev98
 */
public class Squirtle extends Pokemon implements IAgua {

    public Squirtle() {
        super(7, "Squirtle", "Agua", "Agua Dulce", "Kanto", 100, 40);
    }

    public Squirtle(int numPokedex, String nombre, String tipo, String habitat, String region, int vida, int ataque) {
        super(numPokedex, nombre, tipo, habitat, region, vida, ataque);
    }

    @Override
    public void atacarPlacaje(Pokemon objetivo) {
        int danio = 10; // Daño de Placaje
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Placaje causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public void atacarPistolaAgua(Pokemon objetivo) {
        int danio = 20; // Daño de Pistola de Agua
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Pistola de Agua causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public void atacarHidrobomba(Pokemon objetivo) {
        int danio = 50; // Daño de Hidrobomba
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Hidrobomba causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public void atacarSurf(Pokemon objetivo) {
        int danio = 35; // Daño de Surf
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Surf causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public String[] getAtaques() {
        return new String[]{"Placaje", "Pistola de Agua", "Hidrobomba", "Surf"};
    }

    @Override
    protected int usarAtaqueEspecifico(int indiceAtaque, Pokemon oponente) {
        switch (indiceAtaque) {
            case 1: atacarPistolaAgua(oponente); break;
            case 2: atacarHidrobomba(oponente); break;
            case 3: atacarSurf(oponente); break;
            default: throw new IllegalArgumentException("Ataque no válido");
        }
        return oponente.getVida();
    }
}