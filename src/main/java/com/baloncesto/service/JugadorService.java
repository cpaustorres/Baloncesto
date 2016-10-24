package com.baloncesto.service;

import com.baloncesto.domain.Equipo;
import com.baloncesto.domain.Jugador;
import com.baloncesto.repository.EquipoRepository;
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

    @Autowired
    private EquipoRepository equiporepository;

    public void testJugadores() {
        //Creamos el PRIMER EQUIPO
        Equipo equipo1 = new Equipo("FcBarcelona","Barcelona",LocalDate.of(1899,10,10));

        //Guardamos el equipo
        equiporepository.save(equipo1);

        //Creamos los 5 jugadores
        Jugador jug1 = new Jugador("JuanCarlos", "Navarro", LocalDate.of(1980, 10, 10), 100, 5, 25, escolta);
        Jugador jug2 = new Jugador("Victor", "Claver", LocalDate.of(1981, 10, 10), 200, 10, 25, alero);
        Jugador jug3 = new Jugador("Shane", "Lawal", LocalDate.of(1982, 10, 10), 300, 15, 25, pivot);
        Jugador jug4 = new Jugador("Aleksandar", "Vezenkov", LocalDate.of(1983, 10, 10), 400, 20, 25, alapivot);
        Jugador jug5 = new Jugador("Tyrese", "Rice", LocalDate.of(1984, 10, 10), 50, 100, 20, base);
        Jugador jug6 = new Jugador("Juan", "Palomez", LocalDate.of(1986, 10, 10), 100, 5, 25, escolta);
        //Añadimos los equipos a cada jugador
        jug1.setEquipo(equipo1);
        jug2.setEquipo(equipo1);
        jug3.setEquipo(equipo1);
        jug4.setEquipo(equipo1);
        jug5.setEquipo(equipo1);
        jug6.setEquipo(equipo1);
        //Guardamos los jugadores
        jugadorRepository.save(jug1);
        jugadorRepository.save(jug2);
        jugadorRepository.save(jug3);
        jugadorRepository.save(jug4);
        jugadorRepository.save(jug5);
        jugadorRepository.save(jug6);



        //Creamos el SEGUNDO EQUIPO

        Equipo equipo2 = new Equipo("RandomTeam","Londres",LocalDate.of(2001,10,10));

        //Guardamos el equipo
        equiporepository.save(equipo2);

        //Creamos los 5 jugadores
        Jugador jug7 = new Jugador("Juan", "Palomo", LocalDate.of(1986, 10, 10), 100, 5, 25, escolta);
        Jugador jug8 = new Jugador("Vin", "Diesel", LocalDate.of(1987, 10, 10), 200, 10, 25, alero);
        Jugador jug9 = new Jugador("Pau", "Gasol", LocalDate.of(1988, 10, 10), 300, 15, 25, pivot);
        Jugador jug10 = new Jugador("Elfo", "Tografo", LocalDate.of(1989, 10, 10), 400, 20, 25, alapivot);
        Jugador jug11 = new Jugador("Shaquille", "O'neal", LocalDate.of(1990, 10, 10), 50, 100, 20, base);

        //Añadimos los equipos a cada jugador
        jug7.setEquipo(equipo2);
        jug8.setEquipo(equipo2);
        jug9.setEquipo(equipo2);
        jug10.setEquipo(equipo2);
        jug11.setEquipo(equipo2);

        //Guardamos los jugadores
        jugadorRepository.save(jug7);
        jugadorRepository.save(jug8);
        jugadorRepository.save(jug9);
        jugadorRepository.save(jug10);
        jugadorRepository.save(jug11);



        //Creamos el TERCER EQUIPO

        Equipo equipo3 = new Equipo("Stucom","Barcelona",LocalDate.of(2015,10,10));

        //Guardamos el equipo
        equiporepository.save(equipo3);

        //Creamos los 5 jugadores
        Jugador jug12 = new Jugador("Carlos", "Paús", LocalDate.of(1985, 10, 10), 100, 5, 25, escolta);
        Jugador jug13 = new Jugador("Pau", "Garcia", LocalDate.of(1993, 10, 10), 200, 10, 25, alero);
        Jugador jug14 = new Jugador("Joan", "Bosch", LocalDate.of(1991, 10, 10), 300, 15, 25, pivot);
        Jugador jug15 = new Jugador("Sergi", "Mateu", LocalDate.of(1989, 10, 10), 400, 20, 25, alapivot);
        Jugador jug16 = new Jugador("Sergi", "Cortes", LocalDate.of(2000, 10, 10), 50, 100, 20, base);

        //Añadimos los equipos a cada jugador
        jug12.setEquipo(equipo3);
        jug13.setEquipo(equipo3);
        jug14.setEquipo(equipo3);
        jug15.setEquipo(equipo3);
        jug16.setEquipo(equipo3);

        //Guardamos los jugadores
        jugadorRepository.save(jug12);
        jugadorRepository.save(jug13);
        jugadorRepository.save(jug14);
        jugadorRepository.save(jug15);
        jugadorRepository.save(jug16);


        //Creamos el CUARTO EQUIPO

        Equipo equipo4 = new Equipo("TheWalkingDead","Barcelona",LocalDate.of(2008,10,10));

        //Guardamos el equipo
        equiporepository.save(equipo4);

        //Creamos los 5 jugadores
        Jugador jug17 = new Jugador("Master", "Carl", LocalDate.of(1985, 10, 10), 100, 5, 25, escolta);
        Jugador jug18 = new Jugador("Michone", "Handemore", LocalDate.of(1993, 10, 10), 200, 10, 25, alero);
        Jugador jug19 = new Jugador("Ric", "Johnson", LocalDate.of(1991, 10, 10), 300, 15, 25, pivot);
        Jugador jug20 = new Jugador("Daryl", "Thompson", LocalDate.of(1989, 10, 10), 400, 20, 25, alapivot);
        Jugador jug21 = new Jugador("Zombie", "Muñón", LocalDate.of(2000, 10, 10), 50, 100, 20, base);

        //Añadimos los equipos a cada jugador
        jug17.setEquipo(equipo4);
        jug18.setEquipo(equipo4);
        jug19.setEquipo(equipo4);
        jug20.setEquipo(equipo4);
        jug21.setEquipo(equipo4);

        //Guardamos los jugadores
        jugadorRepository.save(jug17);
        jugadorRepository.save(jug18);
        jugadorRepository.save(jug19);
        jugadorRepository.save(jug20);
        jugadorRepository.save(jug21);

        //Creamos el QUINTO EQUIPO

        Equipo equipo5 = new Equipo("Chiringuito","Madrid",LocalDate.of(2008,10,10));

        //Guardamos el equipo
        equiporepository.save(equipo5);

        //Creamos los 5 jugadores
        Jugador jug22 = new Jugador("Xusep", "Pedrerol", LocalDate.of(1985, 10, 10), 100, 5, 25, escolta);
        Jugador jug23 = new Jugador("Lobo", "Carrasco", LocalDate.of(1993, 10, 10), 200, 10, 25, alero);
        Jugador jug24 = new Jugador("Cristobal", "Soria", LocalDate.of(1991, 10, 10), 300, 15, 25, pivot);
        Jugador jug25 = new Jugador("Quim", "Domenech", LocalDate.of(1989, 10, 10), 400, 20, 25, alapivot);
        Jugador jug26 = new Jugador("Alvaro", "Benito", LocalDate.of(2000, 10, 10), 50, 100, 20, base);

        //Añadimos los equipos a cada jugador
        jug22.setEquipo(equipo5);
        jug23.setEquipo(equipo5);
        jug24.setEquipo(equipo5);
        jug25.setEquipo(equipo5);
        jug26.setEquipo(equipo5);

        //Guardamos los jugadores
        jugadorRepository.save(jug22);
        jugadorRepository.save(jug23);
        jugadorRepository.save(jug24);
        jugadorRepository.save(jug25);
        jugadorRepository.save(jug26);

        System.out.println("Jugadores con el nombre Elfo");
        System.out.println(jugadorRepository.findBynombre("Elfo"));

        System.out.println("Jugadores con 400 canastas o mas");
        System.out.println(jugadorRepository.findBycanastasGreaterThanEqual(400));

        System.out.println("Jugadores que tengan entre ");
        System.out.println(jugadorRepository.findByasistenciasBetween(10, 25));

        System.out.println("Jugadores que sean bases");
        System.out.println(jugadorRepository.findByposicion(base));

        System.out.println("Jugadores que hayan nacido antes de una fecha");
        System.out.println(jugadorRepository.findByfechanacimientoBefore(LocalDate.of(1994, 1, 1)));

        jugadorRepository.avgJugadoresperposition().forEach(posicion ->
                System.out.println("posicion =" + posicion[0] + "media canastas " + posicion[1] + "media asistencias" + posicion[2] + "media rebotes " + posicion[3]));


      jugadorRepository.avgmaxminJugadoresperposition().forEach( posicion ->
               System.out.println("posicion =" + posicion[0] + "media canastas " + posicion[1] + "media asistencias" + posicion[2] + "media rebotes " + posicion[3] + "min canastas " + posicion[4] + "min asistencias " + posicion[5] + "min rebotes " + posicion[6] + "min canastas " + posicion[7] + "min asistencias " + posicion[8] + "min rebotes " + posicion[9]));


        System.out.println(equiporepository.findBylocalidad("Madrid"));

        System.out.println(jugadorRepository.findByEquipoNombre("Chiringuito"));

        System.out.println(jugadorRepository.findByEquipoNombreAndPosicion("Chiringuito",alero));


    }

}




