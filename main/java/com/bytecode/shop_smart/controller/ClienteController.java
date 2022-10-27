/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.controller;

import com.bytecode.shop_smart.model.LoginModeller;
import com.bytecode.shop_smart.model.ClienteModel;
import com.bytecode.shop_smart.repository.ClienteRepository;
import com.bytecode.shop_smart.utility.Utility;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping()
    public List<ClienteModel> GetAllCliente() {
        return (List<ClienteModel>) clienteRepository.findAll();
    }

    @GetMapping(path = "/id/{cliente_id}")
    public ResponseEntity<ClienteModel> GetIdCliente(@PathVariable("cliente_id") Long clienteId) {
        Optional<ClienteModel> clienteOptional = clienteRepository.findById(clienteId);
        if (clienteOptional.isPresent()) {
            return new ResponseEntity<>(clienteOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/apellido/{apellido}")//"/query")
    public Optional<ClienteModel> GetByApellido(@PathVariable("apellido") String apellido) {
        return this.clienteRepository.findByApellido(apellido);
    }
    
    @PostMapping(path = "/logo")
    public ResponseEntity<ClienteModel> FindByUserAndClave(@RequestBody LoginModeller loginModeller) {
        Optional<ClienteModel> logOptional = clienteRepository.findByUsuarioAndClave(loginModeller.getUsuario(), Utility.StringToHash512(loginModeller.getClave()));
        System.out.println(loginModeller.getUsuario()+" "+loginModeller.getClave());
        if (logOptional.isPresent()) {
            return new ResponseEntity<>(logOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        return this.clienteRepository.findByUsuarioAndClave(usuario, clave);
    }

    @PostMapping()
    public ClienteModel SaveCliente(@RequestBody @Validated ClienteModel clienteModel) {
        clienteModel.setClave(Utility.StringToHash512(clienteModel.getClave())); // Estamos creando un Hash a el obj Clave.
        return this.clienteRepository.save(clienteModel);
    }

    @PutMapping("/borrar/{cliente_id}")
    public ResponseEntity<ClienteModel> DeliteByIdCLiente(@PathVariable("cliente_id") Long clienteId, @RequestBody ClienteModel clienteModel) {
        Optional<ClienteModel> clienteOptional = clienteRepository.findById(clienteId);
        if (clienteOptional.isPresent()) {
            ClienteModel contactoModelData = clienteOptional.get();

            contactoModelData.setEstado(false);// Pasamos el parametro directo como Falso para no borrar la data.

            return new ResponseEntity<>(clienteRepository.save(contactoModelData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modifica/{cliente_id}")
    public ResponseEntity<ClienteModel> upDateCliente(@PathVariable("cliente_id") Long clienteIdLong, @RequestBody ClienteModel clienteModel) {
        Optional<ClienteModel> clienteOptional = clienteRepository.findById(clienteIdLong);
        if (clienteOptional.isPresent()) {
            ClienteModel clienteData = clienteOptional.get();
            clienteData.setNombre(clienteModel.getNombre());
            clienteData.setApellido(clienteModel.getApellido());
            clienteData.setTelefono(clienteModel.getTelefono());
            clienteData.setCorreo(clienteModel.getCorreo());
            clienteData.setDireccion(clienteModel.getDireccion());
            clienteData.setNota(clienteModel.getNota());
            clienteData.setUsuario(clienteModel.getUsuario());
            clienteData.setClave(clienteModel.getClave());
            clienteData.setTipoUsuarioModel(clienteModel.getTipoUsuarioModel());
            clienteData.setPrecioUsuario(clienteModel.getPrecioUsuario());
            clienteData.setPrecioUsuario(clienteModel.getPrecioUsuario());
            return new ResponseEntity<>(clienteRepository.save(clienteData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
