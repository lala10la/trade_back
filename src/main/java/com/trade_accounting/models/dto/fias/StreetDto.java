package com.trade_accounting.models.dto.fias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StreetDto {
    private Integer id;
    private String name;
    private CityDto cityDto;
}
