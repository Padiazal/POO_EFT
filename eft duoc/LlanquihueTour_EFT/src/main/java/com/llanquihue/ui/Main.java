package com.llanquihue.ui;

import com.llanquihue.data.GestorEntidades;
import com.llanquihue.model.*;
import com.llanquihue.util.Separador;

public class Main {
    public static void main(String[] args) {

        Separador.titulo("sistema de gestión central - llanquihue tour");

        GestorEntidades gestor = new GestorEntidades();

        System.out.println("Importando base de datos de la agencia desde archivo .txt...");
        gestor.cargarDatosDesdeArchivo("datos_agencia.txt");
        System.out.println("Importación finalizada con éxito.\n");

        // 1. INGRESO PERSONA
        Separador.titulo("1. operacion: ingreso de nuevo registro de persona");
        try {
            System.out.println("Ingresando nuevo registro -> Nombre: Andres Silva | RUT: 17666555-4 | Dirección: Los Pinos 33, Puerto Varas | Categoría: Premium");
            Rut rutNuevo = new Rut("17666555-4");
            Direccion dirNueva = new Direccion("Los Pinos 33", "Puerto Varas");
            gestor.agregarElemento(new Cliente("Andres Silva", rutNuevo, dirNueva, "Premium"));
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }

        // 2. INGRESO RUTA
        Separador.titulo("2. operacion: ingreso de nuevo registro de ruta turistica");
        System.out.println("Ingresando nuevo registro -> Ruta Los Colonos | Actividades: Museo y Termas | Horarios: 09:00 - 18:00 | Guía a cargo: Camila Vega | Precio Total: $45000");
        gestor.agregarElemento(new PaqueteTuristico("Ruta Los Colonos", "Museo y Termas", "09:00 - 18:00", "Camila Vega", 45000));

        // 3. CONSULTA PERSONAS
        Separador.titulo("3. operacion: modulo de consulta parcial de personas");
        System.out.println("Buscando en el sistema coincidencias con 'ca':");
        gestor.filtrarPersonasPorNombreParcial("ca");

        // 4. CONSULTA RUTAS
        Separador.titulo("4. operacion: modulo de consulta parcial de rutas");
        System.out.println("Buscando en el sistema coincidencias con 'CO':");
        gestor.filtrarRutasPorNombreParcial("CO");

        // 5. FILTRADO POR ROL
        Separador.titulo("5. operacion: filtrado por rol (solo guias)");
        gestor.filtrarPorRol("GUIA");

        // 6. FILTRADO RUTA POR GUÍA
        Separador.titulo("6. operacion: filtrado de rutas por persona a cargo (Camila Vega)");
        gestor.filtrarRutasPorGuia("Camila Vega");

        // =========================================================
        // 7. MODIFICACIÓN APLICADA (Apunta a Ruta Los Pinos,
        // actualizando el horario a 10:30 - 14:45 y precio a 30000)
        // =========================================================
        Separador.titulo("7. operacion: modificacion de ruta (horarios y precio)");
        gestor.modificarRuta("Ruta Los Pinos", "10:30 - 14:45", 30000);

        // 8. NUEVOS REGISTROS PERSONAS
        Separador.titulo("8. operacion: registros nuevos de personas ingresadas");
        gestor.mostrarNuevosRegistros("PERSONA");

        // 9. NUEVOS REGISTROS RUTAS
        Separador.titulo("9. operacion: registros nuevos de rutas ingresadas");
        gestor.mostrarNuevosRegistros("RUTA");

        // 10. LISTADOS FINALES
        Separador.titulo("listado final de personas en bbdd:");
        gestor.generarListadoFinalPersonas();

        Separador.titulo("listado final de rutas ingresadas:");
        gestor.generarListadoFinalRutas();

        System.out.println("\n");
        Separador.titulo("cierre de sesion");
    }
}