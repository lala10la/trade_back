package com.trade_accounting.repositories.company;

import com.trade_accounting.models.entity.company.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address getAddressById(Long id);
}
