package com.trade_accounting.repositories.warehouse;

import com.trade_accounting.models.entity.warehouse.ShipmentProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentProductRepository extends JpaRepository<ShipmentProduct,Long>, JpaSpecificationExecutor<ShipmentProduct> {
}
