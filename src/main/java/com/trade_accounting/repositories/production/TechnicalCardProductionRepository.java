package com.trade_accounting.repositories.production;

import com.trade_accounting.models.entity.production.TechnicalCardProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalCardProductionRepository extends JpaRepository<TechnicalCardProduction, Long> {
}
