package com.bytecode.shop_smart.controller;



import com.bytecode.shop_smart.model.SuplidorModelo;
import com.bytecode.shop_smart.repository.SuplidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suplidor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class SuplidorController {

    @Autowired
    SuplidorRepository suplidorRepository;

    @GetMapping()
    public List<SuplidorModelo> FindAllSuplidor (){
        return (List<SuplidorModelo>) suplidorRepository.findAll();
    }

    @GetMapping(path = "/id/{suplidor_id}")
    public ResponseEntity<SuplidorModelo> FindByIdSuplidor(@PathVariable("suplidor_id") Long suplidor_id){
        Optional<SuplidorModelo> optionalModel = suplidorRepository.findById(suplidor_id);

        if(optionalModel.isPresent()){
            return new ResponseEntity<>(optionalModel.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/nombre/{nombre}")
    public ResponseEntity<SuplidorModelo> FindByNombreSuplidor(@PathVariable("nombre") String nombre){
        Optional<SuplidorModelo> optionalModel = suplidorRepository.findByNombre(nombre);

        if(optionalModel.isPresent()){
            return new ResponseEntity<>(optionalModel.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping()
    public SuplidorModelo SaveSuplidor (@RequestBody @Validated SuplidorModelo suplidorModelo){
        return this.suplidorRepository.save(suplidorModelo);
    }

    @PutMapping("/borrar/{suplidor_id}")
    public ResponseEntity<SuplidorModelo> DeleteByIdSuplidor(@PathVariable("suplidor_id") Long suplidorId, @RequestBody SuplidorModelo suplidorModelo) {
        Optional<SuplidorModelo> suplidorOptional = suplidorRepository.findById(suplidorId);
        if (suplidorOptional.isPresent()) {
            SuplidorModelo contactoModelData = suplidorOptional.get();

            contactoModelData.setEstado(false);// Pasamos el parametro directo como Falso para no borrar la data.

            return new ResponseEntity<>(suplidorRepository.save(contactoModelData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modificar/{suplidor_id}")
    public ResponseEntity<SuplidorModelo> upDateSuplidor (@PathVariable("suplidor_id") Long suplidorId, @RequestBody SuplidorModelo suplidorModelo) {
        Optional<SuplidorModelo> suplidorOptional = suplidorRepository.findById(suplidorId);
        if (suplidorOptional.isPresent()) {
            SuplidorModelo suplidorData = suplidorOptional.get();
            suplidorData.setNombre(suplidorModelo.getNombre());
            suplidorData.setCorreo(suplidorModelo.getCorreo());
            suplidorData.setDireccion(suplidorModelo.getDireccion());
            suplidorData.setTelefono(suplidorModelo.getTelefono());


            return new ResponseEntity<>(suplidorRepository.save(suplidorData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
