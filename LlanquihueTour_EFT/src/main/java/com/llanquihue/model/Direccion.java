package com.llanquihue.model;

//creamos la dirección como un objeto reutilizable,como composicion,
//pues un cliente tiene una direccion (has a ) y sin direccion no esta completo

public class Direccion {
    private String calle, ciudad;

    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() { return calle + ", " + ciudad; }
}