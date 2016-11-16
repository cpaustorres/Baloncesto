package com.baloncesto.repository;

import com.baloncesto.domain.Equipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by usu26 on 20/10/2016.
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long> {


    List<Equipo> findBylocalidad(String localidad);

    @Query("select p from Equipo p order by p.localidad")
    List<Equipo> EquipoPosicionLoc();
}
