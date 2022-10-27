package com.bytecode.shop_smart.repository;

import com.bytecode.shop_smart.model.ArticuloModelo;
import com.bytecode.shop_smart.model.SuplidorModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SuplidorRepository extends CrudRepository<SuplidorModelo, Long> {

    public abstract Optional<SuplidorModelo> findByNombre (String nombre);

}
