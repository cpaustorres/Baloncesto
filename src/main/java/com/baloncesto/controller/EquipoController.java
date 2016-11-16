package com.baloncesto.controller;

import com.baloncesto.domain.Equipo;
import com.baloncesto.repository.EquipoRepository;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by usu26 on 03/11/2016.
 */
@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired

    private EquipoRepository equipoRepository;

    /*POST*/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo crearEquipo(@RequestBody Equipo equipo){
        return equipoRepository.save(equipo);
    }

    /*PUT*/
    @PutMapping
    public Equipo modificarequipo(@RequestBody Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    /*GET TODOS*/
    @GetMapping
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    /*GET POR EQUIPO*/
    @GetMapping("/{id}")
    public Equipo findById(@PathVariable Long id){
        Equipo equipo =  equipoRepository.findOne(id);
        return equipo;
    }
    /*DELETE*/
    @DeleteMapping("/{id}")
    public void BorrarEquipo(@PathVariable Long id) {
        equipoRepository.delete(id);
    }


    @GetMapping("/JugadorPosicionMap")
    public Map<String, Collection<Equipo>> EquipoPosicionLoc(){
        List<Equipo> jugadores = equipoRepository.EquipoPosicionLoc();

        ListMultimap<String, Equipo> playerMultiMap = ArrayListMultimap.create();

        for(Equipo p: jugadores){
            playerMultiMap.put(p.getLocalidad(), p);
        }
        return playerMultiMap.asMap();
    }

}
