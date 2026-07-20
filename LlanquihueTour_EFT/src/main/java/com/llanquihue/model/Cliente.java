package com.llanquihue.model;
//cliente es child de persona, asi hereda nombre rut y direccion
//pero categoria es solo suyo
public class Cliente extends Persona {
    private String categoria;

    public Cliente(String nombre, Rut rut, Direccion direccion, String categoria) {
        super(nombre, rut, direccion);
        this.categoria = categoria;
    }

    //uso de mostrar datos y registrar de registrable, completando el polimorfismo
    @Override
    public void registrar() {
        System.out.println(">>> Guardando ficha de Cliente...");
    }

    @Override
    public void mostrarDatos() {
        System.out.println(nombre + "  ->  [CLIENTE] RUT: " + rut + " | Dirección: " + direccion + " | Categoría: " + categoria);
    }
}
