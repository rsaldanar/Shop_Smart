package com.bytecode.shop_smart.repository;

import com.bytecode.shop_smart.model.AlmacenModelo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AlmacenRepository extends CrudRepository<AlmacenModelo, Long>{

   public abstract Optional<AlmacenModelo> findByNombre(String nombre);
   
   public abstract Optional<AlmacenModelo> findByResponsable(String responsable);
   
   public abstract Optional<AlmacenModelo> findByEstado(Boolean estado);

}
