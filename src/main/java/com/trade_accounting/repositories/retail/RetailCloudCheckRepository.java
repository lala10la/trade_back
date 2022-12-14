package com.trade_accounting.repositories.retail;

import com.trade_accounting.models.entity.retail.RetailCloudCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailCloudCheckRepository extends JpaRepository<RetailCloudCheck,Long>, JpaSpecificationExecutor<RetailCloudCheck> {
}
