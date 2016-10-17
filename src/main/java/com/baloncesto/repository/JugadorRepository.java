package com.baloncesto.repository;

import com.baloncesto.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by usu26 on 14/10/2016.
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador> findBynombre(String nombre);
    List<Jugador> findBycanastasGreaterThanEqual(Integer canastas);
    List<Jugador> findByasistenciasBetween(Integer min, Integer max);
    List<Jugador> findByposicion(String posicion);
    List<Jugador> findByfechanacimientoBefore(LocalDate fechanacimiento);

    @Query("SELECT jugador.posicion, AVG(jugador.canastas), AVG(jugador.asistencias), AVG(jugador.rebotes) " +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")

    List<Object[]> avgJugadoresperposition();

}
