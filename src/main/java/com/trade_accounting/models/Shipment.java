package com.trade_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipments")

public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date")
    private LocalDateTime date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Contractor contractor;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    private List<ShipmentProduct> shipmentProducts;

    @Column(name = "paid")
    private BigDecimal paid;

    @Column(name = "is_spend")
    @ColumnDefault("false")
    private Boolean isSpend;

    @Column(name = "is_send")
    @ColumnDefault("false")
    private Boolean isSend;

    @Column(name = "is_print")
    @ColumnDefault("false")
    private Boolean isPrint;

    @Column(name = "comment")
    private String comment;

}

