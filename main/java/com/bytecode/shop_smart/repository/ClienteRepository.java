/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.repository;


import java.util.List;

import com.bytecode.shop_smart.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rsaldana
 */

public interface ClienteRepository extends CrudRepository<ClienteModel, Long>{
    
    public List<ClienteModel> findByNombre(String nombre);
    
    public List<ClienteModel> findByApellido(String apellido);
    
    
}
