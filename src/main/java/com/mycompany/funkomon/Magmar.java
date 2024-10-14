package com.mycompany.funkomon;

public class Magmar extends Pokemon implements IFuego {

    public Magmar() {
        super(126, "Magmar", "Fuego", "Montaña", "Kanto", 150, 100);
    }
    
    public Magmar(int numPokedex, String nombre, String tipo, String habitat, String region, int vida, int ataque) {
        super(numPokedex, nombre, tipo, habitat, region, vida, ataque);
    }
    
     @Override
    public void atacarPlacaje(Pokemon objetivo) {
        int danio = 20; // Daño de Placaje
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Placaje causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public void atacarLanzallamas(Pokemon objetivo) {
        int danio = 40; // Daño de Lanzallamas
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Lanzallamas causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public void atacarLlamarada(Pokemon objetivo) {
        int danio = 50; // Daño de Llamarada
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Llamarada causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public void atacarPunioFuego(Pokemon objetivo) {
        int danio = 35; // Daño de Puño Fuego
        objetivo.recibirDanio(danio);
        System.out.println(getNombre() + " usó Puño Fuego causando " + danio + " de daño a " + objetivo.getNombre());
    }

    @Override
    public String[] getAtaques() {
        return new String[]{"Placaje", "Lanzallamas", "Llamarada", "Puño Fuego"};
    }

    @Override
    protected int usarAtaqueEspecifico(int indiceAtaque, Pokemon oponente) {
        switch (indiceAtaque) {
            case 1: atacarLanzallamas(oponente); break;
            case 2: atacarLlamarada(oponente); break;
            case 3: atacarPunioFuego(oponente); break;
            default: throw new IllegalArgumentException("Ataque no válido");
        }
        return oponente.getVida();
    }
}
