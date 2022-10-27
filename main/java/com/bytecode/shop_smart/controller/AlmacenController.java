package com.bytecode.shop_smart.controller;


import com.bytecode.shop_smart.model.AlmacenModelo;
import com.bytecode.shop_smart.model.ArticuloModelo;
import com.bytecode.shop_smart.repository.AlmacenRepository;
import java.util.Date;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/almacen")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class AlmacenController {

    @Autowired
    AlmacenRepository almacenRepository;

    @GetMapping()
    public List<AlmacenModelo> FindAllAlmacen(){
        return (List<AlmacenModelo>) almacenRepository.findAll();
    }

    @GetMapping(path = "/id/{almacen_id}")    
    public ResponseEntity<AlmacenModelo> FindByIdAlmacen (@PathVariable("almacen_id") Long almacenId){
        Optional<AlmacenModelo> almacenOptional = almacenRepository.findById(almacenId);

        if (almacenOptional.isPresent()){
            return new ResponseEntity<>(almacenOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    
    @GetMapping(path = "/name/{nombre}")
    public ResponseEntity<AlmacenModelo> FindByName(@PathVariable("nombre") String nombre){
        Optional<AlmacenModelo> nameOptional = almacenRepository.findByNombre(nombre);
        if (nameOptional.isPresent()) {
            return new ResponseEntity<>(nameOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(path = "/responsable/{responsable}")
    public ResponseEntity<AlmacenModelo> FindByResponsalbe(@PathVariable("responsable") String responsable){
        Optional<AlmacenModelo> responsableOptional = almacenRepository.findByResponsable(responsable);
        if (responsableOptional.isPresent()) {
            return new ResponseEntity<>(responsableOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
     @GetMapping(path = "/estado/{estado}")
    public ResponseEntity<AlmacenModelo> FindByEstado(@PathVariable("estado") boolean estado){
        Optional<AlmacenModelo> estadoOptional = almacenRepository.findByEstado(estado);
        if (estadoOptional.isPresent()) {
            return new ResponseEntity<>(estadoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping()
    public AlmacenModelo SaveAlmacen(@RequestBody() @Validated AlmacenModelo almacenModelo){
        return almacenRepository.save(almacenModelo);
    }
    


    @PutMapping("/borrar/{almacen_id}")
    public ResponseEntity<AlmacenModelo> DeliteByIdAlmacen(@PathVariable("almacen_id") Long almacenId, @RequestBody AlmacenModelo almacenModelo) {
        Optional<AlmacenModelo> almacenOptional = almacenRepository.findById(almacenId);
        if (almacenOptional.isPresent()) {
            AlmacenModelo contactoModelData = almacenOptional.get();

            contactoModelData.setEstado(false);// Pasamos el parametro directo como Falso para no borrar la data.

            return new ResponseEntity<>(almacenRepository.save(contactoModelData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PutMapping("/modificar/{almacen_id}")
    public ResponseEntity<AlmacenModelo> upDateAlmacen (@PathVariable("almacen_id") Long almacenId, @RequestBody AlmacenModelo almacenModelo) {
        Optional<AlmacenModelo> almacenOptional = almacenRepository.findById(almacenId);
        if (almacenOptional.isPresent()) {
            AlmacenModelo almacenData = almacenOptional.get();
            almacenData.setNombre(almacenModelo.getNombre());
            almacenData.setResponsable(almacenModelo.getResponsable());

            return new ResponseEntity<>(almacenRepository.save(almacenData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
