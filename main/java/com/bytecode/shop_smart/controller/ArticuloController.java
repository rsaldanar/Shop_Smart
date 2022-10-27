package com.bytecode.shop_smart.controller;

import com.bytecode.shop_smart.model.ArticuloModelo;
import com.bytecode.shop_smart.model.ClienteModel;
import com.bytecode.shop_smart.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class ArticuloController {

    @Autowired
    ArticuloRepository articuloRepository;

    @GetMapping()
    public List<ArticuloModelo> FindAllArticulo (){
        return (List<ArticuloModelo>) articuloRepository.findAll();
    }

    @GetMapping(path = "/id/{articulo_id}")
    public ResponseEntity<ArticuloModelo> FindByIdArticulo(@PathVariable("articulo_id") Long articulo_id){
        Optional<ArticuloModelo> optionalModel = articuloRepository.findById(articulo_id);

        if(optionalModel.isPresent()){
            return new ResponseEntity<>(optionalModel.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/nombre/{nombre}")
    public ResponseEntity<ArticuloModelo> FindByNombreArticulo(@PathVariable("nombre") String nombre){
        Optional<ArticuloModelo> optionalModel = articuloRepository.findByNombre(nombre);

        if(optionalModel.isPresent()){
            return new ResponseEntity<>(optionalModel.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/marca/{marca}")
    public ResponseEntity<ArticuloModelo> FindByMarcaArticulo(@PathVariable("marca") String marca){
        Optional<ArticuloModelo> optionalModel = articuloRepository.findByMarca(marca);

        if(optionalModel.isPresent()){
            return new ResponseEntity<>(optionalModel.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ArticuloModelo SaveArticulo (@RequestBody @Validated ArticuloModelo articuloModelo){
        int contador = (int) ((articuloRepository.count())+1);
        articuloModelo.setArticuloId(contador);
        return this.articuloRepository.save(articuloModelo);
//        System.out.println(contador);
    }
      
    
    @PutMapping("/borrar/{articulo_id}")
    public ResponseEntity<ArticuloModelo> DeleteByIdArticulo(@PathVariable("articulo_id") Long articuloId, @RequestBody ArticuloModelo articuloModelo) {
        Optional<ArticuloModelo> articuloOptional = articuloRepository.findById(articuloId);
        if (articuloOptional.isPresent()) {
            ArticuloModelo contactoModelData = articuloOptional.get();

            contactoModelData.setEstado(false);// Pasamos el parametro directo como Falso para no borrar la data.

            return new ResponseEntity<>(articuloRepository.save(contactoModelData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modificar/{articulo_id}")
    public ResponseEntity<ArticuloModelo> upDateArticulo (@PathVariable("articulo_id") Long articuloId, @RequestBody ArticuloModelo articuloModelo) {
        Optional<ArticuloModelo> articuloOptional = articuloRepository.findById(articuloId);
        if (articuloOptional.isPresent()) {
            ArticuloModelo articuloData = articuloOptional.get();
            articuloData.setNombre(articuloModelo.getNombre());
            articuloData.setMarca(articuloModelo.getMarca());
            articuloData.setMedidaModel(articuloModelo.getMedidaModel());
            return new ResponseEntity<>(articuloRepository.save(articuloData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
