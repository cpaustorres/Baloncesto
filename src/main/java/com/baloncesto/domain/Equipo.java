package com.baloncesto.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by usu26 on 17/10/2016.
 */
//identificador, nombre, localidad y fecha de
//
//        creación

public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String localidad;
    private LocalDate fechacreacion;

    public Equipo(String nombre, String localidad, LocalDate fechacreacion) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.fechacreacion = fechacreacion;
    }
    public Equipo(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (!id.equals(equipo.id)) return false;
        if (!nombre.equals(equipo.nombre)) return false;
        if (!localidad.equals(equipo.localidad)) return false;
        return fechacreacion.equals(equipo.fechacreacion);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nombre.hashCode();
        result = 31 * result + localidad.hashCode();
        result = 31 * result + fechacreacion.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", fechacreacion=" + fechacreacion +
                '}';
    }
}
