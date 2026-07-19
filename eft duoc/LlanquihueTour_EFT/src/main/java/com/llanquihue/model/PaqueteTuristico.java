package com.llanquihue.model;

/**
 * Representa los itinerarios y paquetes de la agencia.
 */
public class PaqueteTuristico implements Registrable {

    private String nombre;
    private String actividades;
    private String horario;
    private String responsable;
    private int precio;

    public PaqueteTuristico(String nombre, String actividades, String horario, String responsable, int precio) {
        this.nombre = nombre;
        this.actividades = actividades;
        this.horario = horario;
        this.responsable = responsable;
        this.precio = precio;
    }

    // Getters para permitir las búsquedas
    public String getNombre() { return nombre; }
    public String getResponsable() { return responsable; }

    // Setters (Mutadores) para permitir la MODIFICACIÓN de la ruta (Trazabilidad)
    public void setHorario(String horario) { this.horario = horario; }
    public void setPrecio(int precio) { this.precio = precio; }

    @Override
    public void registrar() {
        // Requerido por la interfaz
    }

    @Override
    public void mostrarDatos() {
        // Formato exacto solicitado en el output
        System.out.println("[PAQUETE TURÍSTICO] " + nombre + " | Actividades: " + actividades +
                " | Horarios: " + horario + " | Guía a cargo: " + responsable +
                " | Precio Total: $" + precio);
    }
}