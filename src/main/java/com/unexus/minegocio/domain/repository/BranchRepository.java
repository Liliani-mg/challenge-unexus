package com.unexus.minegocio.domain.repository;

import com.unexus.minegocio.domain.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchRepository {
    List<Branch> getAll();
    Branch save(Branch branch);
    Optional<Branch> registerAddressForClient(Long clientId, Branch address);

    Optional<Branch> getBranch(long id);

    void delete(long id);


    Optional<Branch> getByClientId(long idClient);
}
