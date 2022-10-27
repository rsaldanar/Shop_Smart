/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.controller;

import com.bytecode.shop_smart.model.TipoUsuarioModel;
import com.bytecode.shop_smart.repository.TipoUsuarioRepository;
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
@RequestMapping("/tipousuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class TipoUsuarioController {
    
    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;
    
    
    @GetMapping()
    public List<TipoUsuarioModel> FindAll() {
        return (List<TipoUsuarioModel>) tipoUsuarioRepository.findAll();
    }

    @GetMapping(path = "/id/{usuario_id}")
    public ResponseEntity<TipoUsuarioModel> FindByIdTipoUsuario(@PathVariable("usuario_id") Long tipoUsuarioId) {
        Optional<TipoUsuarioModel> clienteOptional = tipoUsuarioRepository.findById(tipoUsuarioId);
        if (clienteOptional.isPresent()) {
            return new ResponseEntity<>(clienteOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/descripcion/{descripcion}")//"/query")
    public Optional<TipoUsuarioModel> FindByDescripcion(@PathVariable("descripcion") String descripcion) {
        return this.tipoUsuarioRepository.findByDescripcion(descripcion);
    }
    

    @PostMapping()
    public TipoUsuarioModel SaveTipoUsuario(@RequestBody @Validated TipoUsuarioModel tipoUsuarioModel) {
        return this.tipoUsuarioRepository.save(tipoUsuarioModel);
    } 
    
    
    
}
