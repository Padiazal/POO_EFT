package com.llanquihue.util;

/**
 * EXCEPCION PERSONALIZADA
 *Si alguien ingresa un RUT con letras fuera de la k
 * o  formato incorrecto, se emite un error
 * Al usar extends ampliamos RutInvalidoException para tener los metodfos de 'Exception'
 * por responsabilidad unica (cada codigo debe hacer una cosa bien) el codigo que valida el rut esta aparte,
 * aqui solo definimoc como se llama y como se va a compartar  el error (como exeption)
 */

// Creamos
public class RutInvalidoException extends Exception {

    //constructor recibe el mensaje de error personalizado y se lo envía
    // a la clase padre (Exception) usando "super" que es la "llave" que los comunica (reservada)
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}