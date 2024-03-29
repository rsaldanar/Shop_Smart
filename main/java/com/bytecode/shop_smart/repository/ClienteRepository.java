/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.repository;


import java.util.List;

import com.bytecode.shop_smart.model.ClienteModel;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rsaldana
 */

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long>{
    
    public abstract Optional<ClienteModel> findByNombre(String nombre);
    
    public abstract Optional<ClienteModel> findByApellido(String apellido);
    
    public abstract Optional<ClienteModel> findByUsuarioAndClave(String usuario, String clave);
    
    
}

