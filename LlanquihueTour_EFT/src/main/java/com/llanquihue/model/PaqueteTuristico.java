package com.llanquihue.model;

/**
 * esta me di cuenta al final que no la habia hecho XD,
 * meti los datos en el mismo txt pues se pueden leer aparte sin problemas
 * Aqui hacemos la trazabilidad de los paquetes turisticos,no puede heredar de persona
 * pues por que no es una persona U_U
 * soi implementa regsitrable pues igual sirve ingresar y mostrar datos para las rutas turisticas
 */
public class PaqueteTuristico implements Registrable {

    private String nombre;
    private String actividades;
    private String horario;
    private String responsable;
    private int precio;

    public PaqueteTuristico(String nombre, String actividades, String horario, String responsable, int precio) {
        this.nombre = nombre;
        this.actividades = actividades;
        this.horario = horario;
        this.responsable = responsable;
        this.precio = precio;
    }

    // Getters para podee buscar deje solo los necvesarios para el ejemplo

    public String getNombre() {
        return nombre;
    }

    public String getActividades() {
        return actividades;
    }

    public String getHorario() {
        return horario;
    }

    public String getResponsable() {
        return responsable;
    }

    public int getPrecio() {
        return precio;
    }


    // Setters para poder modificar , (lo que noS da trazabilidad mediente el registro de las acciones)

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//override de nuevo para mostrar texto bien y el println para dar formato
    @Override
    public void registrar() {
    }

    @Override
    public void mostrarDatos() {
        // Formato exacto solicitado en el output
        System.out.println("[PAQUETE TURÍSTICO] " + nombre + " | Actividades: " + actividades +
                " | Horarios: " + horario + " | Guía a cargo: " + responsable +
                " | Precio Total: $" + precio);
    }
}