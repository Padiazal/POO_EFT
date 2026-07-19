package com.llanquihue.model;

/**
 * INTERFAZ DE CONTRATO
 * ¿Por qué se usa?: Una interfaz no dice "qué es" un objeto, sino "qué debe saber hacer".
 * Necesidad: Al obligar a Clientes y Guías a firmar este contrato, nos aseguramos
 * de que el gestor pueda tratarlos a todos por igual (Polimorfismo).
 */
public interface Registrable {
    // Todos los que implementen esta interfaz DEBEN tener estos métodos.
    void registrar();
    void mostrarDatos();
}