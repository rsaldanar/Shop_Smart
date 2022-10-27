/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.controller;

import com.bytecode.shop_smart.model.ArticuloModelo;
import com.bytecode.shop_smart.model.ClienteModel;
import com.bytecode.shop_smart.model.MedidaModel;
import com.bytecode.shop_smart.repository.MedidaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.servlet.annotation.HttpConstraint;

/**
 *
 * @author rsaldana
 */
@RestController
@RequestMapping("/medida")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class MedidaController {
    
    // presentacion;  unidad;
    
    @Autowired
    MedidaRepository medidaRepository;
    
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
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
    public MedidaModel SavMedida(@RequestBody  MedidaModel medida){
        return this.medidaRepository.save(medida);
    }

    @PutMapping("/borrar/{medida_id}")
    public ResponseEntity<MedidaModel> DeliteByIdMedida(@PathVariable("medida_id") Long medidaId, @RequestBody MedidaModel medidaModel) {
        Optional<MedidaModel> medidaOptional = medidaRepository.findById(medidaId);
        if (medidaOptional.isPresent()) {
            MedidaModel contactoModelData = medidaOptional.get();

            contactoModelData.setEstado(false);// Pasamos el parametro directo como Falso para no borrar la data.

            return new ResponseEntity<>(medidaRepository.save(contactoModelData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modificar/{medida_id}")
    public ResponseEntity<MedidaModel> updateMedida (@PathVariable("medida_id") Long medidaId, @RequestBody MedidaModel medidaModel) {
        Optional<MedidaModel> medidaOptional = medidaRepository.findById(medidaId);
        if (medidaOptional.isPresent()) {
            MedidaModel medidaData = medidaOptional.get();
            medidaData.setUnidad(medidaModel.getUnidad());
            medidaData.setPresentacion(medidaModel.getPresentacion());
            return new ResponseEntity<>(medidaRepository.save(medidaData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
