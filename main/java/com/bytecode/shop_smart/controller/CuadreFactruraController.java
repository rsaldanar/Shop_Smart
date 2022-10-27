package com.bytecode.shop_smart.controller;

import com.bytecode.shop_smart.model.CuadreFacturaModelo;
import com.bytecode.shop_smart.repository.CuadreFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuadreFactura")
public class CuadreFactruraController {

    @Autowired
    CuadreFacturaRepository cuadreFacturaRepository;


    @RequestMapping("/getAll")
    public List<CuadreFacturaModelo> getAll() {
        return (List<CuadreFacturaModelo>) cuadreFacturaRepository.findAll();
    }

    @GetMapping(path = "/getid/{id_cuadre_factura}")
    public ResponseEntity<CuadreFacturaModelo> getIdCuadre(@PathVariable("id_cuadre_factura") long cuadreFacturaId) {
        Optional<CuadreFacturaModelo> cuadreFacturaModelo = cuadreFacturaRepository.findById(cuadreFacturaId);
        if (cuadreFacturaModelo.isPresent()) {
            return new ResponseEntity<>(cuadreFacturaModelo.get(), org.springframework.http.HttpStatus.OK);
        }else {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getultima")
    public ResponseEntity<CuadreFacturaModelo> getUltima() {
        long count = cuadreFacturaRepository.count();
        getIdCuadre(count);
        if (count > 0) {
        return new ResponseEntity<>(cuadreFacturaRepository.findById(count).get(), org.springframework.http.HttpStatus.OK);
        }else {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping()
    public ResponseEntity<CuadreFacturaModelo> saveCuadreFactura(@RequestBody() @Validated CuadreFacturaModelo cuadreFacturaModelo) {
        CuadreFacturaModelo saveOptional = cuadreFacturaRepository.save(cuadreFacturaModelo);
        if (saveOptional != null) {
        return new ResponseEntity<>(cuadreFacturaModelo, org.springframework.http.HttpStatus.OK);
        }else {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }

    // update cuadreFactura
    @PutMapping("/{id_cuadre_factura}")
    public ResponseEntity<CuadreFacturaModelo> updateCuadreFactura(@PathVariable("id_cuadre_factura") long cuadreFacturaId,
                                                                  @RequestBody() @Validated CuadreFacturaModelo cuadreFacturaModelo) {
        Optional<CuadreFacturaModelo> cuadreFacturaModeloOptional = cuadreFacturaRepository.findById(cuadreFacturaId);
        if (cuadreFacturaModeloOptional.isPresent()) {
            cuadreFacturaModelo.getTotalCajaFinal();
            cuadreFacturaModelo.getFechaCierre();
            CuadreFacturaModelo saveOptional = cuadreFacturaRepository.save(cuadreFacturaModelo);
            return new ResponseEntity<>(saveOptional, org.springframework.http.HttpStatus.OK);
        }else {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }
}
