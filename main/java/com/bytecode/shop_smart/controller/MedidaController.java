/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.controller;

import com.bytecode.shop_smart.model.MedidaModel;
import com.bytecode.shop_smart.repository.MedidaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rsaldana
 */
@RestController
@RequestMapping("/medida")
public class MedidaController {
    
    // presentacion;  unidad;
    
    @Autowired
    MedidaRepository medidaRepository;
    
    @GetMapping()
    public List<MedidaModel> FindByAllMedida(){
        return (List<MedidaModel>) medidaRepository.findAll();
    }
    
    
    @GetMapping(path = "/presentacion/{presentacion}")
    public ResponseEntity<MedidaModel> FindByPresentacion(@PathVariable("presentacion") String presentacion){
        Optional<MedidaModel> medidaOptional = medidaRepository.findByPresentacion(presentacion);
        if (medidaOptional.isPresent()) {
            return new ResponseEntity<>(medidaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(path = "/unidad/{unidad}")
    public ResponseEntity<MedidaModel> FindByUnidad(@PathVariable("unidad") String unidad){
        Optional<MedidaModel> medidaOptional = medidaRepository.findByUnidad(unidad);
        if (medidaOptional.isPresent()) {
            return new ResponseEntity<>(medidaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping()
    public MedidaModel SavMedida(@RequestBody MedidaModel medida){
        return medidaRepository.save(medida);
    }
    
    
}
