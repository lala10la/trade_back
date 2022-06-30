package com.trade_accounting.models.dto.warehouse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfAccountingDto {

    private Long id;

    private String name;

    private String sortNumber;
}
