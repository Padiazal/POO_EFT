package com.llanquihue.model;

import com.llanquihue.util.RutInvalidoException;

/**
 * CLASE DE ENCAPSULAMIENTO Y VALIDACIÓN
 * ¿Por qué se usa?: Separar el RUT en su propia clase permite reutilizar su
 * validación en Clientes, Guías, Proveedores, etc., sin duplicar código.
 */
public class Rut {
    // Atributo privado: Nadie desde afuera puede modificar este valor directamente.
    private String valor;

    // Constructor que lanza nuestra excepción si el dato es malo.
    public Rut(String valor) throws RutInvalidoException {
        // Expresión regular: Obliga a ingresar números, un guion, y un dígito (0-9 o K).
        // Evita fraudes o errores de tipeo en la base de datos de Llanquihue Tour.
        if (valor == null || !valor.matches("[1-9]+-[0-9kK]")) {
            throw new RutInvalidoException("El formato del RUT ingresado no es válido.");
        }
        // Si pasa la validación, lo guarda en mayúsculas (ej: k -> K)
        this.valor = valor.toUpperCase();
    }

    // Sobrescritura: Cuando se imprima el objeto, mostrará el texto, no un espacio de memoria.
    @Override
    public String toString() { return valor; }
}