/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.controller;

import com.bytecode.shop_smart.model.ClienteModel;
import com.bytecode.shop_smart.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author rsaldana
 */

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    
    
    @Autowired
    ClienteRepository clienteRepository;
    
    
    
    @GetMapping()
    public List<ClienteModel> GetAllCliente(){
        return (List<ClienteModel>) clienteRepository.findAll();
    }
    
    @GetMapping(path = "/id/{cliente_id}")
    public ResponseEntity<ClienteModel> GetIdCliente(@PathVariable("cliente_id") Long clienteId){
        Optional<ClienteModel> clienteOptional = clienteRepository.findById(clienteId);
        if (clienteOptional.isPresent()) {
            return new ResponseEntity<>(clienteOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(path = "/nombre/{nombre}")//"/query")
    public List<ClienteModel> GetByNombre(@PathVariable("nombre") String nombre){
        return this.clienteRepository.findByNombre(nombre);
    }
    
    @GetMapping(path = "/apellido/{apellido}")//"/query")
    public List<ClienteModel> GetByApellido(@PathVariable("apellido") String apellido){
        return this.clienteRepository.findByApellido(apellido);
    }
     
    @PostMapping()
    public ClienteModel SaveCliente(@RequestBody @Validated ClienteModel clienteModel){
        return this.clienteRepository.save(clienteModel);
    }
    
    @PutMapping("/borrar/{cliente_id}")
    public ResponseEntity<ClienteModel> upDateCLiente (@PathVariable("cliente_id") Long clienteId, @RequestBody ClienteModel clienteModel) {
        Optional<ClienteModel> clienteOptional = clienteRepository.findById(clienteId);
        if (clienteOptional.isPresent()) {
            ClienteModel contactoModelData = clienteOptional.get();
            
            contactoModelData.setEstado(false);// Pasamos el parametro directo como Falso para no borrar la data.

            return new ResponseEntity<>(clienteRepository.save(contactoModelData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
