/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.repository;

import com.bytecode.shop_smart.model.MedidaModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rsaldana
 */
@Repository
public interface MedidaRepository extends CrudRepository<MedidaModel, Long>{
    
    Optional<MedidaModel> findByPresentacion(String presentacion);
    
    Optional<MedidaModel> findByUnidad(String unidad);
}
