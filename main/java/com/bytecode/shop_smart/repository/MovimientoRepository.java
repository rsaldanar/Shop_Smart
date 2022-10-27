package com.bytecode.shop_smart.repository;

import com.bytecode.shop_smart.model.ClienteModel;
import com.bytecode.shop_smart.model.MovimientoModelo;
import java.util.Optional;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends CrudRepository<MovimientoModelo, Long> {
    public abstract Optional<MovimientoModelo> findByDocumentoEntrada(String documentoEntrada);
}
