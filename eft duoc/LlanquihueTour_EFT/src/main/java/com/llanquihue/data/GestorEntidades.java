package com.llanquihue.data;

import com.llanquihue.model.*;
import com.llanquihue.util.RutInvalidoException;

import java.io.*;
import java.util.*;

public class GestorEntidades {

    private final List<Registrable> lista = new ArrayList<>();
    private final List<Registrable> listaArchivo = new ArrayList<>();
    private final List<Registrable> listaNuevos = new ArrayList<>();

    public void cargarDatosDesdeArchivo(String ruta) {
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");

                // EXTRACCIÓN CON ÍNDICES EXACTOS Y SIN TRIM
                String tipo = datos[0];

                if (tipo.equalsIgnoreCase("CLIENTE") || tipo.equalsIgnoreCase("GUIA")) {
                    String nombre = datos[1];
                    String numRut = datos[2];
                    String calle = datos[3];
                    String ciudad = datos[4];
                    String extra = datos[5];

                    Rut r = new Rut(numRut);
                    Direccion dir = new Direccion(calle, ciudad);

                    Registrable persona = tipo.equalsIgnoreCase("CLIENTE")
                            ? new Cliente(nombre, r, dir, extra)
                            : new GuiaTuristico(nombre, r, dir, extra);

                    lista.add(persona);
                    listaArchivo.add(persona);

                } else if (tipo.equalsIgnoreCase("PAQUETE")) {
                    String nombrePaquete = datos[1];
                    String actividades = datos[2];
                    String horario = datos[3];
                    String responsable = datos[4];

                    // Conversión directa sin trim
                    int precio = Integer.parseInt(datos[5]);

                    Registrable paquete = new PaqueteTuristico(nombrePaquete, actividades, horario, responsable, precio);
                    lista.add(paquete);
                    listaArchivo.add(paquete);
                }
            }
        } catch (IOException | RutInvalidoException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Omitiendo registro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error numérico: " + e.getMessage() + ". Revisa la columna del precio.");
        }
    }

    public void agregarElemento(Registrable nuevoRegistro) {
        lista.add(nuevoRegistro);
        listaNuevos.add(nuevoRegistro);
        System.out.println("Elemento agregado exitosamente.");
    }

    // =========================================================
    // MÓDULOS DE BÚSQUEDA Y MODIFICACIÓN
    // =========================================================
    public void filtrarPersonasPorNombreParcial(String fragmento) {
        boolean encontrado = false;
        for (Registrable reg : lista) {
            if (reg instanceof Persona p) {
                if (p.getNombre().toLowerCase().contains(fragmento.toLowerCase())) {
                    reg.mostrarDatos();
                    encontrado = true;
                }
            }
        }
        if (!encontrado) System.out.println("Sin resultados");
    }

    public void filtrarRutasPorNombreParcial(String fragmento) {
        boolean encontrado = false;
        for (Registrable reg : lista) {
            if (reg instanceof PaqueteTuristico pt) {
                if (pt.getNombre().toLowerCase().contains(fragmento.toLowerCase())) {
                    pt.mostrarDatos();
                    encontrado = true;
                }
            }
        }
        if (!encontrado) System.out.println("Sin resultados");
    }

    public void filtrarPorRol(String rolBuscado) {
        for (Registrable reg : lista) {
            if (rolBuscado.equalsIgnoreCase("GUIA") && reg instanceof GuiaTuristico) reg.mostrarDatos();
            else if (rolBuscado.equalsIgnoreCase("CLIENTE") && reg instanceof Cliente) reg.mostrarDatos();
        }
    }

    public void filtrarRutasPorGuia(String nombreGuia) {
        boolean encontrado = false;
        for (Registrable reg : lista) {
            if (reg instanceof PaqueteTuristico pt) {
                if (pt.getResponsable().equalsIgnoreCase(nombreGuia)) {
                    pt.mostrarDatos();
                    encontrado = true;
                }
            }
        }
        if (!encontrado) System.out.println("Sin resultados");
    }

    public void modificarRuta(String nombreRuta, String nuevoHorario, int nuevoPrecio) {
        for (Registrable reg : lista) {
            if (reg instanceof PaqueteTuristico pt) {
                if (pt.getNombre().equalsIgnoreCase(nombreRuta)) {
                    System.out.print("SELECCIONANDO RUTA SOLICITADA : ");
                    pt.mostrarDatos();

                    System.out.println("MODIFICANDO LOS HORARIOS Y PRECIO POR LOS NUEVOS HORARIOS INGRESADOS");
                    pt.setHorario(nuevoHorario);
                    pt.setPrecio(nuevoPrecio);

                    System.out.println("RUTA CON DATOS MODIFICADOS:");
                    pt.mostrarDatos();
                    return;
                }
            }
        }
        System.out.println("Ruta no encontrada.");
    }

    // =========================================================
    // REPORTES FINALES
    // =========================================================
    public void mostrarNuevosRegistros(String tipo) {
        boolean encontrado = false;
        for (Registrable reg : listaNuevos) {
            if (tipo.equals("PERSONA") && reg instanceof Persona) {
                reg.mostrarDatos();
                encontrado = true;
            } else if (tipo.equals("RUTA") && reg instanceof PaqueteTuristico) {
                reg.mostrarDatos();
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Sin resultados\n");
    }

    public void generarListadoFinalPersonas() {
        for (Registrable reg : lista) {
            if (reg instanceof Persona) {
                reg.mostrarDatos();
            }
        }
    }

    public void generarListadoFinalRutas() {
        for (Registrable reg : lista) {
            if (reg instanceof PaqueteTuristico) {
                reg.mostrarDatos();
            }
        }
    }
}