package com.llanquihue.model;

public class Cliente extends Persona {
    private String categoria;

    public Cliente(String nombre, Rut rut, Direccion direccion, String categoria) {
        super(nombre, rut, direccion);
        this.categoria = categoria;
    }

    @Override
    public void registrar() {
        // Se mantiene por contrato de la interfaz, pero ya no se imprimirá en el listado final
        System.out.println(">>> Guardando ficha de Cliente...");
    }

    @Override
    public void mostrarDatos() {
        // Formato limpio: Nombre a la izquierda, datos extras a la derecha
        System.out.println(nombre + "  ->  [CLIENTE] RUT: " + rut + " | Dirección: " + direccion + " | Categoría: " + categoria);
    }
}
