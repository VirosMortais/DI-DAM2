package com.virosms.sol.entities;

public class Planeta {

    private String nombre;
    private String diametro;
    private String distanciaSol;
    private String densidad;

    public Planeta() {
    }

    public Planeta(String nombre, String diametro, String distanciaSol, String densidad) {
        this.nombre = nombre;
        this.diametro = diametro;
        this.distanciaSol = distanciaSol;
        this.densidad = densidad;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiametro() {
        return diametro;
    }

    public void setDiametro(String diametro) {
        this.diametro = diametro;
    }

    public String getDistanciaSol() {
        return distanciaSol;
    }

    public void setDistanciaSol(String distanciaSol) {
        this.distanciaSol = distanciaSol;
    }

    public String getDensidad() {
        return densidad;
    }

    public void setDensidad(String densidad) {
        this.densidad = densidad;
    }
}
