package com.llanquihue.util;

/** Para no tener que escribir "=====" manualmente cada vez que
 * queremos un título en la consola. hace que se vea mas pro
 */

// final evita la herencia
public final class Separador {


    // Constructor vacío privado: evita que se creen objetos desde fuera
    private Separador() {}

//"dibujamos" las lineas que podremos llamar usando "separador.titulo"
    public static void titulo(String texto) {
        System.out.println("\n======================================");
        System.out.println(texto.toUpperCase());
        System.out.println("======================================");
    }
}