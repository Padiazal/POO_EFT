package com.llanquihue.model;

public class GuiaTuristico extends Persona {
    private String especialidad;

    public GuiaTuristico(String nombre, Rut rut, Direccion direccion, String especialidad) {
        super(nombre, rut, direccion);
        this.especialidad = especialidad;
    }

    @Override
    public void registrar() {
        // Se mantiene por contrato de la interfaz, pero ya no se imprimirá en el listado final
        System.out.println(">>> Validando credenciales...");
    }

    @Override
    public void mostrarDatos() {
        // Formato limpio: Nombre a la izquierda, datos extras a la derecha
        System.out.println(nombre + "  ->  [GUÍA] RUT: " + rut + " | Dirección: " + direccion + " | Especialidad: " + especialidad);
    }
}