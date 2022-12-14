package com.trade_accounting.models.entity.purchases;

import com.trade_accounting.models.entity.company.Company;
import com.trade_accounting.models.entity.company.Contractor;
import com.trade_accounting.models.entity.units.SalesChannel;
import com.trade_accounting.models.entity.warehouse.Product;
import com.trade_accounting.models.entity.warehouse.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Класс-модель управление закупками
 *
 * @param id              - номер закупки
 * @param productName     - наименование товара
 * @param data            - дата
 * @param productCode     - код товара
 * @param articleNumber   - артикул
 * @param productMeasure  - единицы измерения
 * @param productQuantity - число товаров
 * @param company - компания
 * @param warehouse - склад
 * @param historyOfSales  - история продаж
 * @param currentBalance  - текущий остаток
 * @param forecast        - число товаров
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "purchase_control")
public class PurchaseControl {
    @Id
    @NotNull
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productName")
    private Product product;

    @NotNull
    @Column(name = "date")
    private LocalDateTime date;

    @NotNull
    private Long productCode;

    @NotNull
    private Long articleNumber;

    @NotNull
    private String productMeasure;

    private Long productQuantity;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    private Company company;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    private Contractor contractor;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PurchaseHistoryOfSales historyOfSales;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PurchaseCurrentBalance currentBalance;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PurchaseForecast forecast;

    @OneToOne(fetch = FetchType.LAZY)
    private SalesChannel salesChannel;
}