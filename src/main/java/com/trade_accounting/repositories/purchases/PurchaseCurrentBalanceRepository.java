package com.trade_accounting.repositories.purchases;

import com.trade_accounting.models.entity.purchases.PurchaseCurrentBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseCurrentBalanceRepository extends JpaRepository<PurchaseCurrentBalance, Long> {

    @Query("SELECT c FROM PurchaseCurrentBalance c")
    List<PurchaseCurrentBalance> findAll();

    @Query("SELECT c FROM PurchaseCurrentBalance c WHERE c.id = :id")
    PurchaseCurrentBalance getOne(@Param("id") Long id);
}
