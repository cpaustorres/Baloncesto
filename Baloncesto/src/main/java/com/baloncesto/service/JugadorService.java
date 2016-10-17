package com.baloncesto.service;

import com.baloncesto.domain.Jugador;
import com.baloncesto.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


/**
 * Created by usu26 on 14/10/2016.
 */
@Service
public class JugadorService {

    @Autowired
      private JugadorRepository jugadorRepository;

    public void testJugadores(){

        Jugador jug1= new Jugador("Master","Carl", LocalDate.of(2010,10,10),100,50,25,"escolta");
        jugadorRepository.save(jug1);

        Jugador jug2= new Jugador("Vin","Diesel", LocalDate.of(2010,10,10),200,50,25,"alero");
        jugadorRepository.save(jug2);

        Jugador jug3= new Jugador("Pau","Gasol", LocalDate.of(2010,10,10),300,50,25,"pivot");
        jugadorRepository.save(jug3);

        Jugador jug4= new Jugador("Elfo","Tografo", LocalDate.of(2010,10,10),400,50,25,"ala-pivot");
        jugadorRepository.save(jug4);

        Jugador jug5= new Jugador("Shaquille","O'neal", LocalDate.of(2010,10,10),500,50,25,"base");
        jugadorRepository.save(jug5);


        System.out.println("Jugadores con el nombre Elfo");
    System.out.println(jugadorRepository.findBynombre("Elfo"));
        System.out.println("Jugadores con 400 canastas o mas");
        System.out.println(jugadorRepository.findBycanastasGreaterThanEqual(400));


    }



}
