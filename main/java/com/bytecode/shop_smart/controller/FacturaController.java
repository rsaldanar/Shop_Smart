/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.controller;

import com.bytecode.shop_smart.model.FacturaModelo;
import com.bytecode.shop_smart.model.FacturaMovimientoModelo;
import com.bytecode.shop_smart.repository.FacturaContadorRepository;
import com.bytecode.shop_smart.repository.FacturaMovimientoRepository;
import com.bytecode.shop_smart.repository.FacturaRepository;
import com.bytecode.shop_smart.repository.MovimientoContadorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rsaldana
 */
@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class FacturaController {
    
    @Autowired
    FacturaRepository facturaRepository;
    
     @Autowired
    FacturaMovimientoRepository facturaMovimientoRepository;
    
    @GetMapping()
    public List<FacturaModelo> FindByAllFactura() {
        return (List<FacturaModelo>) facturaRepository.findAll();
    }

    @GetMapping(path = "/id/{factura_id}")
    public ResponseEntity<FacturaModelo> FindByIdFactura(@PathVariable("factura_id") Long facturaIdLong) {
        Optional<FacturaModelo> facturaOptional = facturaRepository.findById(facturaIdLong);
        if (facturaOptional.isPresent()) {
            return new ResponseEntity<>(facturaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(path = "/numero/{factura_numero}")
    public ResponseEntity<FacturaModelo> FindByFacturaNumero(@PathVariable("factura_numero") int facturaId) {
        Optional<FacturaModelo> facturaOptional = facturaRepository.findByFacturaNumero(facturaId);
        if (facturaOptional.isPresent()) {
            return new ResponseEntity<>(facturaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Metodo para agrupar por fecha
    @GetMapping(path = "/fecha/{fecha}")
    public ResponseEntity<List<FacturaModelo>> FindByFecha(@PathVariable("fecha") String fecha) {
        List<FacturaModelo> facturaList = facturaRepository.findByFecha(fecha);
        if (facturaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(facturaList, HttpStatus.OK);
        }
    }
    
    @Autowired
    FacturaContadorRepository facturaContador;
    
    @PostMapping()
    public FacturaModelo SaveFactura(@RequestBody @Validated FacturaModelo facturaModelo) {
        facturaModelo.setFacturaNumero((int)(facturaContador.count()+1));
        return facturaRepository.save(facturaModelo);
        
    }

    @Autowired
    MovimientoContadorRepository movimientoContadorRepository;
    
    @PostMapping("savemovi")
    public FacturaMovimientoModelo SaveFactura(@RequestBody @Validated FacturaMovimientoModelo facturaMovimientoModelo){
        facturaMovimientoModelo.setMovimientoNumero((int) (facturaMovimientoRepository.count()+1));
        return this.facturaMovimientoRepository.save(facturaMovimientoModelo);
    }
    
    @GetMapping("/movi")
    public List<FacturaMovimientoModelo> FindByAllMovimientoFactura() {
        return (List<FacturaMovimientoModelo>) facturaMovimientoRepository.findAll();
    }

    // metodo que guarda en las tablas factura y en la tabla movimiento

}
