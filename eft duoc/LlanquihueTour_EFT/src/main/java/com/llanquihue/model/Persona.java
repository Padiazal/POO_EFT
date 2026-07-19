package com.llanquihue.model;

/**
 * SUPERCLASE ABSTRACTA
 * ¿Por qué es abstracta?: Porque en el mundo real no existe una "Persona" genérica
 * en la agencia, solo existen "Clientes" o "Guías". No queremos que se instancie.
 * Necesidad: Centraliza los datos comunes. Evita repetir código en las subclases.
 */
public abstract class Persona implements Registrable {
    // 'protected' permite que las clases hijas puedan acceder a estos atributos.
    protected String nombre;

    // COMPOSICIÓN (relación "tiene un/una"):
    protected Rut rut;
    protected Direccion direccion;

    // Constructor que será llamado por los hijos usando la palabra 'super'
    public Persona(String nombre, Rut rut, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    // Getter necesario para poder realizar búsquedas por nombre más adelante
    public String getNombre() {
        return nombre;
    }
}