/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.controller;

import com.bytecode.shop_smart.model.RecepsionDineroModel;
import com.bytecode.shop_smart.repository.RecepsionDineroRepository;
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
@RequestMapping("/entradadinero")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class RecepsionDineroController {

    @Autowired
    RecepsionDineroRepository recepsionDineroRepository;

    @GetMapping()
    public List<RecepsionDineroModel> FindAllRecepsionDinero() {
        return (List<RecepsionDineroModel>) recepsionDineroRepository.findAll();
    }

    @GetMapping("/id/{recepcion_id}")
    public ResponseEntity<RecepsionDineroModel> FindByIdRecepcionDinero(@PathVariable("recepcion_id") Long recepcionId) {
        Optional<RecepsionDineroModel> datosOptional = recepsionDineroRepository.findById(recepcionId);

        if (datosOptional.isPresent()) {
            return new ResponseEntity<>(datosOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cajero/{responsable}")
    public ResponseEntity<RecepsionDineroModel> FindByResponsable(@PathVariable("responsable") String responsable) {
        Optional<RecepsionDineroModel> ordenOptional = recepsionDineroRepository.findByResponsable(responsable);

        if (ordenOptional.isPresent()) {
            return new ResponseEntity<>(ordenOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public RecepsionDineroModel SaveRecepsionDinero(@RequestBody @Validated RecepsionDineroModel recepsionDineroModel) {
//        int dosM = recepsionDineroModel.getDosMil()*2000;
//        int unoM = recepsionDineroModel.getUnMil()*1000;
//        int cincoC = recepsionDineroModel.getQuiniento()*500;
//        int cienC = recepsionDineroModel.getCien()*100;
//        int doscientosC = recepsionDineroModel.getDosCiento()*200;
//        int cincuentaD = recepsionDineroModel.getCincuenta()*50;
//        int veinteCincos = recepsionDineroModel.getVenteycinco()*25;
//        int veinteD = recepsionDineroModel.getVente()*20;
//        int diezDU = recepsionDineroModel.getDiez()*10;
//        int cincoU = recepsionDineroModel.getCinco()*5;
//        int unoU = recepsionDineroModel.getUno()*1;
//        // int total = dosM + unoM + cincoC + cienC + doscientosC + cincuentaD + veinteCincos + veinteD + diezDU + cincoU + unoU;
//        int total = dosM + unoM + cincoC + cienC + doscientosC + cincuentaD + veinteCincos + veinteD + diezDU + cincoU + unoU;
//        recepsionDineroModel.setTotal(total);
        return this.recepsionDineroRepository.save(recepsionDineroModel);
    }

    // Metodo get que agrupado por responsable y fecha
    @GetMapping("/responsable/{responsable}/fecha/{fecha}")
    public ResponseEntity<RecepsionDineroModel> FindByResponsableAndFecha(@PathVariable("responsable") String responsable, @PathVariable("fecha") String fecha) {
        Optional<RecepsionDineroModel> ordenOptional = recepsionDineroRepository.findByResponsableAndFecha(responsable, fecha);

        if (ordenOptional.isPresent()) {
            return new ResponseEntity<>(ordenOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
