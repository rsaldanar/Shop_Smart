package com.bytecode.shop_smart.controller;


import com.bytecode.shop_smart.model.AlmacenModelo;
import com.bytecode.shop_smart.model.OrdenCompraModelo;
import com.bytecode.shop_smart.repository.OrdenCompraRepository;
import com.bytecode.shop_smart.repository.OrdenContadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordencompra")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class OrdenCompraController {

    @Autowired
    OrdenCompraRepository ordenCompraRepository;
    
    @Autowired
    OrdenContadorRepository contadorOrdenRepository;


    @GetMapping()
    public List<OrdenCompraModelo> FindAllOrdenCompra (){
        return (List<OrdenCompraModelo>) ordenCompraRepository.findAll();
    }

    @GetMapping("/id/{orden_compra_id}")
    public ResponseEntity<OrdenCompraModelo> FindByIdOrdenCompra (@PathVariable("orden_compra_id") Long ordenId){
        Optional<OrdenCompraModelo> ordenOptional = ordenCompraRepository.findById(ordenId);

        if(ordenOptional.isPresent()){
            return new ResponseEntity<>(ordenOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<OrdenCompraModelo> FindByNumeroOrdenCompra (@PathVariable("numero") Integer numeroOrden){
        Optional<OrdenCompraModelo> ordenOptional = ordenCompraRepository.findByNumeroOrden(numeroOrden);

        if (ordenOptional.isPresent()){
            return new ResponseEntity<>(ordenOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public OrdenCompraModelo SaveOrdenCompra (@RequestBody @Validated OrdenCompraModelo ordenCompraModelo){
        
        ordenCompraModelo.setNumeroOrden((int) contadorOrdenRepository.count()+1);
        return this.ordenCompraRepository.save(ordenCompraModelo);
        
        
    }
    
//    @PostMapping()
//    public List<OrdenCompraModelo> SaveAllOrdenCompra(List<OrdenCompraModelo> ordenCompraModelos){
//        List<OrdenCompraModelo> saveOrdenCompra = (List<OrdenCompraModelo>) ordenCompraRepository.saveAll(ordenCompraModelos);
//        return saveOrdenCompra;
//    }
    
//    @PostMapping()
//    public List<OrdenCompraModelo> SaveAllOrdenCompra(List<OrdenCompraModelo> ordenCompraModelos){
//        System.out.println(ordenCompraModelos.size());
////        ordenCompraModelos.size();
//        List<OrdenCompraModelo> saveOrdenCompra = (List<OrdenCompraModelo>) ordenCompraRepository.saveAll(ordenCompraModelos);
//        return saveOrdenCompra;
//    }

    
    @PutMapping("/borrar/{orden_compra_id}")
    public ResponseEntity<OrdenCompraModelo> updateOrdenCompra(@PathVariable("orden_compra_id") Long ordenId, @RequestBody OrdenCompraModelo ordenCompraModelo) {
        Optional<OrdenCompraModelo> ordenOptional = ordenCompraRepository.findById(ordenId);
        if (ordenOptional.isPresent()) {
            OrdenCompraModelo contactoModelData = ordenOptional.get();

            contactoModelData.setEstado(false);// Pasamos el parametro directo como Falso para no borrar la data.

            return new ResponseEntity<>(ordenCompraRepository.save(contactoModelData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PutMapping("/modificar/{orden_compra_id}")
    public ResponseEntity<OrdenCompraModelo> upDateOrdenCompra (@PathVariable("orden_compra_id") Long ordenId, @RequestBody OrdenCompraModelo ordenCompraModelo) {
        Optional<OrdenCompraModelo> ordenOptional = ordenCompraRepository.findById(ordenId);
        if (ordenOptional.isPresent()) {
            OrdenCompraModelo ordenCompraData = ordenOptional.get();
            ordenCompraData.setCantidad(ordenCompraModelo.getCantidad());
            ordenCompraData.setMonto(ordenCompraModelo.getMonto());
            ordenCompraData.setPrecio(ordenCompraModelo.getPrecio());
            return new ResponseEntity<>(ordenCompraRepository.save(ordenCompraData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    

}

