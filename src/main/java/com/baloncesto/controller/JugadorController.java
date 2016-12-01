package com.baloncesto.controller;

import com.baloncesto.controller.util.HeaderUtil;
import com.baloncesto.domain.Jugador;
import com.baloncesto.domain.Posicion;
import com.baloncesto.repository.JugadorRepository;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.net.URI;
import java.util.*;

/**
 * Created by usu26 on 24/10/2016.
 */
@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)

       public ResponseEntity<Jugador> createPlayer(@RequestBody Jugador player) throws URISyntaxException {
              if (player.getId() != null) {
                       return ResponseEntity.
                                       badRequest().
                                       headers(
                                              HeaderUtil.
                                                              createFailureAlert("player", "idexists", "A new player cannot already have an ID")).body(null);
                   }
        Jugador result = jugadorRepository.save(player);
              return ResponseEntity.created(new URI("/players/" + result.getId()))
                               .headers(HeaderUtil.createEntityCreationAlert("player", result.getId().toString()))
                               .body(result);
    }



    @RequestMapping(method = RequestMethod.GET)
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public Jugador findById(@PathVariable Long id) {
        Jugador jugador = jugadorRepository.findOne(id);
        return jugador;
    }


    /*JUGADOR 1- */
    @GetMapping("/ByOrderByCanastas/")
    public List<Jugador> findByOrderByCanastasDesc() {
        return jugadorRepository.findByOrderByCanastasDesc();
    }


    /**/
    @GetMapping("/byCanastas/{canastas}")
    public List<Jugador> findByCanastasGreaterThan(@PathVariable Integer canastas) {
        return jugadorRepository.findByCanastasGreaterThan(canastas);
    }
    @GetMapping("/byCanastasBetween/{min}/{max}")
    public List<Jugador> findByCanastasBetween(@PathVariable Integer min,@PathVariable Integer max) {
        return jugadorRepository.findByCanastasBetween(min,max);
    }


    @GetMapping("/posicionAndMedia")
    public Map<Posicion, EstadisticasPosicion> findByPosicionAndMedia() {

        List<Object[]> estadisticasPosicions = jugadorRepository.findByPosicionAndMedia();

        Map<Posicion, EstadisticasPosicion> estadisticasPosicionMap = new HashMap<>();

        estadisticasPosicions.
                forEach(estadisticasPosicion -> {

                    EstadisticasPosicion aux = new EstadisticasPosicion();
                    aux.setPosicion((Posicion) estadisticasPosicion[0]);
                    aux.setMinCanastas((Integer) estadisticasPosicion[1]);
                    aux.setMaxCanastas((Integer) estadisticasPosicion[2]);
                    aux.setAvgCanastas((Double) estadisticasPosicion[3]);

                    estadisticasPosicionMap.put(aux.getPosicion(), aux);

                });
        return estadisticasPosicionMap;
    }

    // GET --> SHOW ALL THE PLAYERS WITH THE SAME POSITION ORDERED BY BASKETS
    @GetMapping("/JugadorPosicionMap")
    public Map<Posicion, Collection<Jugador>> JugadorPosicionMap(){
        List<Jugador> jugadores = jugadorRepository.JugadorPosicionMap();

        ListMultimap<Posicion, Jugador> playerMultiMap = ArrayListMultimap.create();

        for(Jugador p: jugadores){
            playerMultiMap.put(p.getPosicion(), p);
        }
        return playerMultiMap.asMap();
    }


    // T0D0 Gestión de errores cuando el parametro de ordenación es invalido.
    @GetMapping
    public List<Jugador> findAllOrderBy(
            @RequestParam(
                    name = "orderBy", required = false) String orderBy,
            @RequestParam(
                    name = "direction",defaultValue = "ASC") String direction
    ){
        if(orderBy != null) {
            Sort sort;
            if (direction.equals("ASC")){
                sort = new Sort(Sort.Direction.ASC, orderBy);
            }
            else{
                sort = new Sort(Sort.Direction.DESC, orderBy);
            }
            return jugadorRepository.findAll(sort);
        }
        return jugadorRepository.findAll();
    }



}
