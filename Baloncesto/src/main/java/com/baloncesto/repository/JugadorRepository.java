package com.baloncesto.repository;

import com.baloncesto.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by usu26 on 14/10/2016.
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador> findBynombre(String nombre);
    List<Jugador> findBycanastasGreaterThanEqual(Integer canastas);

}
