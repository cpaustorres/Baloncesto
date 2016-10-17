package com.baloncesto.domain;

/**
 * Created by usu26 on 14/10/2016.
 */
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    private LocalDate fechanacimiento;
    private Integer canastas;
    private Integer asistencias;
    private Integer rebotes;
    private String posicion;

    public Jugador() {}


    public Jugador(String nombre, LocalDate fechanacimiento, Integer canastas, Integer asistencias, Integer rebotes, String posicion) {
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.posicion = posicion;
    }


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

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Integer getCanastas() {
        return canastas;
    }

    public void setCanastas(Integer canastas) {
        this.canastas = canastas;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getRebotes() {
        return rebotes;
    }

    public void setRebotes(Integer rebotes) {
        this.rebotes = rebotes;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (id != jugador.id) return false;
        if (!nombre.equals(jugador.nombre)) return false;
        if (!fechanacimiento.equals(jugador.fechanacimiento)) return false;
        if (!canastas.equals(jugador.canastas)) return false;
        if (!asistencias.equals(jugador.asistencias)) return false;
        if (!rebotes.equals(jugador.rebotes)) return false;
        return posicion.equals(jugador.posicion);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + nombre.hashCode();
        result = 31 * result + fechanacimiento.hashCode();
        result = 31 * result + canastas.hashCode();
        result = 31 * result + asistencias.hashCode();
        result = 31 * result + rebotes.hashCode();
        result = 31 * result + posicion.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechanacimiento='" + fechanacimiento + '\'' +
                ", canastas=" + canastas +
                ", asistencias=" + asistencias +
                ", rebotes=" + rebotes +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}