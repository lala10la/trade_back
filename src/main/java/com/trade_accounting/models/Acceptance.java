package com.trade_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "acceptances")
public class Acceptance extends OperationsAbstract {


    @Column(name = "incoming_number")
    private String incomingNumber;


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Contractor contractor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;

    @Column(name = "is_spend")
    @ColumnDefault("false")
    Boolean isSpend = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeChanged;

    @Column(name = "when_changed_date")
    private LocalDate whenСhangedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;


    @OneToMany(fetch = FetchType.LAZY)
    private List<AcceptanceProduction> acceptanceProduction;
}
