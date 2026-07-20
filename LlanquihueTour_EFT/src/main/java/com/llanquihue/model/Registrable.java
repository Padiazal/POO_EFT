package com.llanquihue.model;


// Contrato que obliga a las clases a funcionar de la misma forma a
// pesar de que estan destinadas a cosas completamente diferentes (Polimorfismo).
public interface Registrable {

//los objetos registrables tienen la obligacion de incluir estros 2 metodos
    void registrar();
    void mostrarDatos();
}