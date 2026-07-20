package com.llanquihue.model;

import com.llanquihue.util.RutInvalidoException;

// validador visto en clases para detectar si esta escrito bien, se usa regex para definir que sean
// numeros del 1 al 9 en el primer caracter, el resto pueden ser del 0 al 9,
// y antes del ultimo va un guion, seguido de un numero del 0 al 9, o una K
//este es el codigo que conversa con RutinvalidoException para entregarle las condiciones a validar,
// o entregar el mensaje "El formato del RUT ingresado no es válido."
// RUT al final hace un encapsulamiento  de la validacion con regex,y este es reutilizado en otras clases
// esto ers una composicion

public class Rut {

    private String valor;

    // Constructor que muestra la excepción si el dato esta fuera de las reglas.
    public Rut(String valor) throws RutInvalidoException {

        if (valor == null || !valor.matches("[1-9]+-[0-9kK]")) {
            throw new RutInvalidoException("El formato del RUT ingresado no es válido.");
        }
        // Si pasa, lo guarda en mayúsculas, sirve para la K netamente
        this.valor = valor.toUpperCase();
    }

    // Sobrescritura par que se muestre el texto y no un codigo raro
    public String toString() { return valor; }
}