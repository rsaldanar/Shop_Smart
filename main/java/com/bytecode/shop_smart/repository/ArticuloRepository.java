package com.bytecode.shop_smart.repository;

import com.bytecode.shop_smart.model.ArticuloModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticuloRepository extends CrudRepository<ArticuloModelo, Long> {

     public abstract Optional<ArticuloModelo> findByNombre(String nombre);

     public abstract Optional<ArticuloModelo> findByMarca(String marca);


}

