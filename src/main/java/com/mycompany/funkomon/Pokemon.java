/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kev98
 */
public abstract class Pokemon {
    protected int numPokedex;
    protected String nombre;
    protected String tipo;
    protected String habitat;
    protected String region;
    protected int vida;
    protected int ataque;

    public Pokemon() {
    }

    public Pokemon(int numPokedex, String nombre, String tipo, String habitat, String region, int vida, int ataque) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.tipo = tipo;
        this.habitat = habitat;
        this.region = region;
        this.vida = 100;
        this.ataque = ataque;
    }

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

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setVida(int vida) {
        this.vida = vida;
        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println(nombre + " se ha debilitado.");
        }
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida <= 0){
            vida = 0;
            System.out.println(nombre + "  se a debilitado ");
        }
    }
    
    public void atacar(Pokemon objetivo, int danio) {
        System.out.println(this.nombre + " ataca a " + objetivo.getNombre() + " causando " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }
    
    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Vida: " + vida;
    }    
    
    protected abstract void atacarPlacaje(Pokemon objetivo);
    protected abstract void atacarMordisco(Pokemon objetivo);
    protected abstract void atacarGruñido(Pokemon objetivo);

    Object getEstadisticas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
