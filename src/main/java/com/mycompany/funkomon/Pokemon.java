package com.mycompany.funkomon;

public abstract class Pokemon {
    protected int numPokedex;
    protected String nombre;
    protected String tipo;
    protected String habitat;
    protected String region;
    protected int vida;
    protected int ataque;

    public Pokemon(int numPokedex, String nombre, String tipo, String habitat, String region, int vida, int ataque) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.tipo = tipo;
        this.habitat = habitat;
        this.region = region;
        this.vida = vida;
        this.ataque = ataque;
    }

    public abstract void atacarPlacaje(Pokemon objetivo);
    
    // Método abstracto que debe ser implementado en las clases concretas según el tipo
    public abstract String[] getAtaques();

    public int usarAtaque(int indiceAtaque, Pokemon oponente) {
        switch (indiceAtaque) {
            case 0: 
                atacarPlacaje(oponente); 
                break;
            case 1: 
                return usarAtaqueEspecifico(indiceAtaque, oponente); // Asegúrate de que haya ataques en los índices 1 y siguientes
            default: 
                throw new IllegalArgumentException("Ataque no válido");
        }
        return oponente.getVida(); // Devuelve la vida del oponente después del ataque
    }

    // Método abstracto para ataques específicos, que se implementará en las clases concretas
    protected abstract int usarAtaqueEspecifico(int indiceAtaque, Pokemon oponente);

    public int getNumPokedex() {
        return numPokedex;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getRegion() {
        return region;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setVida(int vida) {
        this.vida = Math.max(vida, 0);
        if (this.vida == 0) {
            System.out.println(nombre + " se ha debilitado.");
        }
    }

    public void recibirDanio(int cantidad) {
        setVida(vida - cantidad);
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Vida: " + vida;
    }

    public String getEstadisticas() {
        return "Pokémon: " + nombre + "\n" +
               "Tipo: " + tipo + "\n" +
               "Hábitat: " + habitat + "\n" +
               "Región: " + region + "\n" +
               "Vida: " + vida + "\n" +
               "Ataque: " + ataque + "\n" +
               "Número de Pokédex: " + numPokedex;
    }
}
