package com.unexus.minegocio.persitence;

import com.unexus.minegocio.domain.Branch;
import com.unexus.minegocio.domain.Client;
import com.unexus.minegocio.domain.repository.BranchRepository;
import com.unexus.minegocio.persitence.crud.SucursalCRUDRepository;
import com.unexus.minegocio.persitence.entity.Sucursal;
import com.unexus.minegocio.persitence.mapper.BranchMapper;
import com.unexus.minegocio.persitence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SucursalRepository implements BranchRepository {

    //dependencias
    @Autowired
    private SucursalCRUDRepository sucursalCRUDRepository;
    @Autowired
    private BranchMapper mapper;


    @Override
    public List<Branch> getAll(){
        List<Sucursal> sucursal = (List<Sucursal>) sucursalCRUDRepository.findAll();
        return mapper.toBranchs(sucursal);
    }


    @Override
    public Branch save(Branch branch){
        Sucursal sucursal = mapper.toSucursal(branch);
        sucursalCRUDRepository.save(sucursal);
        return branch;
    }

    //Direccion por cliente
    @Override
    public Optional<Branch> registerAddressForClient(Long clientId, Branch address) {
        Sucursal sucursal = mapper.toSucursal(address);
        sucursal.getCliente().setIdCliente(clientId);
        return Optional.ofNullable(mapper.toBranch(sucursalCRUDRepository.save(sucursal)));
    }

    @Override
    public Optional<Branch> getBranch(long id) {
        return sucursalCRUDRepository.findById(id).map(branch -> mapper.toBranch(branch));
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Optional<Branch> getByClientId(long idClient) {
        return sucursalCRUDRepository.findByClient(idClient).map(sucursal -> mapper.toBranch(sucursal));

    }
}
