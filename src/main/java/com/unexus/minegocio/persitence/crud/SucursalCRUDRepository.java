package com.unexus.minegocio.persitence.crud;

import com.unexus.minegocio.persitence.entity.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SucursalCRUDRepository extends CrudRepository<Sucursal,Long> {


    //Find  sucursal by client
    @Query(value = "SELECT * FROM sucursal WHERE id_cliente = :idCliente",nativeQuery = true)
    Optional<Sucursal>  findByClient(@Param("idCliente") Long idCliente);
    
}
