package com.bytecode.shop_smart.controller;


import com.bytecode.shop_smart.model.ClienteModel;
import com.bytecode.shop_smart.model.MovimientoModelo;
import com.bytecode.shop_smart.repository.MovimientoContadorRepository;
import com.bytecode.shop_smart.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimiento")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class MovimientoController {

    @Autowired
    MovimientoRepository movimientoRepository;

    @GetMapping()
    public List<MovimientoModelo> FindByAllMovimiento (){
        return (List<MovimientoModelo>) movimientoRepository.findAll();
    }

    @GetMapping(path = "/id/{movimiento_id}")
    public ResponseEntity<MovimientoModelo> FindByIdMovimiento(@PathVariable("movimiento_id") Long moviminetoId) {
        Optional<MovimientoModelo> movimientoOptional = movimientoRepository.findById(moviminetoId);
        if (movimientoOptional.isPresent()) {
            return new ResponseEntity<>(movimientoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(path = "/documento/{documento_entrada}")//"/query")
    public ResponseEntity<MovimientoModelo> FindByDocumentoEntrada(@PathVariable("documento_entrada") String documentoEntrada) {
        Optional<MovimientoModelo> movimientoOptional = movimientoRepository.findByDocumentoEntrada(documentoEntrada);
        if (movimientoOptional.isPresent()) {
            return new ResponseEntity<>(movimientoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @Autowired
    MovimientoContadorRepository movimientoContador;


    @PostMapping()
    public MovimientoModelo SaveMovimiento(@RequestBody @Validated MovimientoModelo movimientoModelo) {
        movimientoModelo.setMovimientoNumero((int) (movimientoContador.count()+1));
        return this.movimientoRepository.save(movimientoModelo);
    }

    @PutMapping("/borrar/{movimiento_id}")
    public ResponseEntity<MovimientoModelo> DeliteByIdMovimiento(@PathVariable("movimiento_id") Long movimientoId, @RequestBody MovimientoModelo movimientoModelo) {
        Optional<MovimientoModelo> movimientoOptional = movimientoRepository.findById(movimientoId);
        if (movimientoOptional.isPresent()) {
            MovimientoModelo contactoModelData = movimientoOptional.get();

            contactoModelData.setEstado(false);// Pasamos el parametro directo como Falso para no borrar la data.

            return new ResponseEntity<>(movimientoRepository.save(contactoModelData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modifica/{movimiento_id}")
    public ResponseEntity<MovimientoModelo> upDateMovimiento (@PathVariable("movimiento_id") Long movimientoId, @RequestBody MovimientoModelo movimientoModelo) {
        Optional<MovimientoModelo> movimientoOptional = movimientoRepository.findById(movimientoId);
        if (movimientoOptional.isPresent()) {
            MovimientoModelo movimientoData = movimientoOptional.get();
            movimientoData.setPrecioCompra(movimientoModelo.getPrecioCompra());
            movimientoData.setPrecioVentaA(movimientoModelo.getPrecioVentaA());
            movimientoData.setPrecioVentaB(movimientoModelo.getPrecioVentaB());
            return new ResponseEntity<>(movimientoRepository.save(movimientoData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
