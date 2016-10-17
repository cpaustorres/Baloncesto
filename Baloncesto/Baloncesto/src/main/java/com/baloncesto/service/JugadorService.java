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

        Jugador Carl= new Jugador("Master-Carl", LocalDate.of(2010,10,10),100,50,25,"alero");
        jugadorRepository.save(Carl);



    }



}
