package com.trade_accounting.repositories.finance;

import com.trade_accounting.models.entity.finance.LossProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LossProductRepository extends JpaRepository<LossProduct,Long>, JpaSpecificationExecutor<LossProduct> {
}
