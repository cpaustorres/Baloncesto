package com.baloncesto.repository;

import com.baloncesto.domain.Equipo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by usu26 on 20/10/2016.
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long> {


    List<Equipo> findBylocalidad(String localidad);

}