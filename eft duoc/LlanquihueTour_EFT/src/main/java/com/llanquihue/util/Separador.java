package com.llanquihue.util;

/**
 * CLASE DE UTILIDAD (ESTÉTICA)
 * ¿Para qué sirve?: Para no tener que escribir "=====" manualmente cada vez que
 * queremos un título en la consola. Centraliza el diseño visual.
 */
public final class Separador {

    // Constructor privado: Se usa para evitar que otro programador intente
    // crear un objeto de esta clase (ej: new Separador()), ya que no tiene sentido
    // instanciar una clase que solo contiene herramientas estáticas.
    private Separador() {}

    // Método estático: Se puede llamar directamente usando Separador.titulo("...");
    // Afecta directamente la legibilidad de la consola para el cliente.
    public static void titulo(String texto) {
        System.out.println("\n======================================");
        System.out.println(texto.toUpperCase());
        System.out.println("======================================");
    }
}