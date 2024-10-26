/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kev98
 */
public class Venusaur extends Pokemon implements IPlanta {
    
    public Venusaur() {
        super(3, "Venusaur", "Planta/Veneno", "Pradera", "Kanto", 150, 100);
    }

    public Venusaur(int numPokedex, String nombre, String tipo, String habitat, String region, int vida, int ataque) {
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
        System.out.println(getNombre() + " ha atacado con Placaje");
        atacar(objetivo, danio);
    }

    @Override
    protected void atacarGruñido(Pokemon objetivo) {
        int danio = 0;
        System.out.println(getNombre() + " ha atacado con Placaje");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarLatigoCepa(Pokemon objetivo) {
        int danio = 35;
        System.out.println(getNombre() + " ha atacado con Placaje");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarSomnifero(Pokemon objetivo) {
    int danio = 45;
        System.out.println(getNombre() + " ha atacado con Placaje");
        atacar(objetivo, danio);
    }

    @Override
    public void atacarGigadrenado(Pokemon objetivo) {
    int danio = 75;
        System.out.println(getNombre() + " ha atacado con Placaje");
        atacar(objetivo, danio);
    }
}
