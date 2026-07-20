package com.llanquihue.model;

/**
 * SUPERCLASE ABSTRACTA
 * engloba para uso comun rut, nombre y direccion para cliente y guia turistico. (uso de herencia)
 // aca implementa registrable o sea que si o si tiene un registrar
 y un mostrar datos como vimos en "registrable.java
 */
public abstract class Persona implements Registrable {
    // protected permite que las clases child puedan acceder a estos atributos
    protected String nombre;

    // COMPOSICION has-a
    protected Rut rut;
    protected Direccion direccion;

    // Constructor que será llamado por los hijos usando la palabra 'super'
    public Persona(String nombre, Rut rut, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    // Getter para poderlo llamar
    public String getNombre() {
        return nombre;
    }
}