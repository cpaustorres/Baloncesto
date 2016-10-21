package com.baloncesto.repository;

import com.baloncesto.domain.Jugador;
import com.baloncesto.domain.Posicion;
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
    List<Jugador> findByposicion(Posicion posicion);
    List<Jugador> findByfechanacimientoBefore(LocalDate fechanacimiento);

    List<Jugador> findByEquipoNombre(String nombre);
    List<Jugador> findByEquipoNombreAndPosicion(String nombre,Posicion posicion);

    //da error pero no es un error
    @Query("SELECT jugador.posicion, AVG(jugador.canastas), AVG(jugador.asistencias), AVG(jugador.rebotes) " +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> avgJugadoresperposition();


    //da error pero no es un error
   @Query("SELECT jugador.posicion, AVG(jugador.canastas), AVG(jugador.asistencias), AVG(jugador.rebotes),  MIN(jugador.canastas), MIN(jugador.asistencias), MIN(jugador.rebotes)," +
            " MAX(jugador.canastas), MAX(jugador.asistencias), MAX(jugador.rebotes) " +
           "FROM Jugador jugador " +
           "GROUP BY jugador.posicion")
   List<Object[]> avgmaxminJugadoresperposition();

}
