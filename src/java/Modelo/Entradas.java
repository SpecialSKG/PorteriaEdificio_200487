
package Modelo;

import java.util.Date;

public class Entradas {
    
    private int id;
    private String nombre;
    private String apellido;
    private int habitacion;
    private Date entrada;

    public Entradas(int id) {
        this.id = id;
        this.entrada = new Date();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getEntrada() {
        return entrada;
    }

}
