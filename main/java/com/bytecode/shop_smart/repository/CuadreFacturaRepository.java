package com.bytecode.shop_smart.repository;

import com.bytecode.shop_smart.model.CuadreFacturaModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuadreFacturaRepository extends CrudRepository<CuadreFacturaModelo, Long> {


}
