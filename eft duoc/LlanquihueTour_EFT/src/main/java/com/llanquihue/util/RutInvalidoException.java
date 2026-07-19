package com.llanquihue.util;

/**
 * EXCEPCIÓN PERSONALIZADA
 * ¿Por qué se usa?: Para proteger el sistema. Si alguien ingresa un RUT con letras
 * o un formato incorrecto, el programa no debe "explotar" ni guardar datos basura.
 * Al heredar de 'Exception', obligamos al sistema a usar un bloque try-catch
 * para manejar el error de forma elegante ante el usuario.
 */
public class RutInvalidoException extends Exception {

    // El constructor recibe el mensaje de error personalizado y se lo envía
    // a la clase padre (Exception) mediante la palabra reservada 'super'
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}