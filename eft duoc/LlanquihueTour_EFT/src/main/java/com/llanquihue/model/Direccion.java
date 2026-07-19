package com.llanquihue.model;

/**
 * CLASE DE COMPOSICIÓN
 * ¿Para qué sirve?: En lugar de llenar a la Persona de variables sueltas (calle, ciudad, etc),
 * empaquetamos la ubicación en un solo objeto reutilizable.
 */
public class Direccion {
    private String calle, ciudad;

    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() { return calle + ", " + ciudad; }
}