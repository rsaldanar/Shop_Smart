/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.repository;

import com.bytecode.shop_smart.model.RecepsionDineroModel;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rsaldana
 */
@Repository
public interface RecepsionDineroRepository extends CrudRepository<RecepsionDineroModel, Long>{
    
    public abstract Optional<RecepsionDineroModel> findByResponsable(String responsable);

    public Optional<RecepsionDineroModel> findByResponsableAndFecha(String responsable, String fecha);
}
