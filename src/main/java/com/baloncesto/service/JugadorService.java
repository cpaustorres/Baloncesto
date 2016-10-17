package com.baloncesto.service;

import com.baloncesto.domain.Jugador;
import com.baloncesto.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.baloncesto.domain.Posicion.*;

/**
 * Created by usu26 on 14/10/2016.
 */
@Service
public class JugadorService {

    @Autowired
      private JugadorRepository jugadorRepository;

    public void testJugadores(){


        Jugador jug1= new Jugador("Master","Carl", LocalDate.of(2010,10,10),100,5,25,escolta);
        jugadorRepository.save(jug1);

        Jugador jug2= new Jugador("Vin","Diesel", LocalDate.of(2010,10,10),200,10,25,alero);
        jugadorRepository.save(jug2);

        Jugador jug3= new Jugador("Pau","Gasol", LocalDate.of(2010,10,10),300,15,25,pivot);
        jugadorRepository.save(jug3);

        Jugador jug4= new Jugador("Elfo","Tografo", LocalDate.of(2010,10,10),400,20,25,alapivot);
        jugadorRepository.save(jug4);

        Jugador jug5= new Jugador("Shaquille","O'neal", LocalDate.of(1993,10,10),50,100,20,base);
        jugadorRepository.save(jug5);

        Jugador jug6= new Jugador("Pepito","Palotes", LocalDate.of(1993,10,10),100,50,10,base);
        jugadorRepository.save(jug6);

        System.out.println("Jugadores con el nombre Elfo");
    System.out.println(jugadorRepository.findBynombre("Elfo"));

        System.out.println("Jugadores con 400 canastas o mas");
        System.out.println(jugadorRepository.findBycanastasGreaterThanEqual(400));

        System.out.println("Jugadores que tengan entre ");
        System.out.println(jugadorRepository.findByasistenciasBetween(10,25));

        System.out.println("Jugadores que sean bases");
      System.out.println(jugadorRepository.findByposicion(base));

        System.out.println("Jugadores que hayan nacido antes de una fecha");
        System.out.println(jugadorRepository.findByfechanacimientoBefore(LocalDate.of(1994,1,1)));

        jugadorRepository.avgJugadoresperposition().forEach( posicion ->
                System.out.println("posicion =" + posicion[0] + "media canastas " + posicion[1] + "media asistencias" + posicion[2] + "media rebotes " + posicion[3]));


        jugadorRepository.avgmaxminJugadoresperposition().forEach( posicion ->
                System.out.println("posicion =" + posicion[0] + "media canastas " + posicion[1] + "media asistencias" + posicion[2] + "media rebotes " + posicion[3] +
                        "min canastas " + posicion[4] + "min asistencias " + posicion[5] + "min rebotes " + posicion[6] +
                        "min canastas " + posicion[7] + "min asistencias " + posicion[8] + "min rebotes " + posicion[9]));
    }


}




