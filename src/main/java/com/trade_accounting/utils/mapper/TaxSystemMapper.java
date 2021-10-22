package com.trade_accounting.utils.mapper;

import com.trade_accounting.models.TaxSystem;
import com.trade_accounting.models.dto.TaxSystemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaxSystemMapper {
    //TaxSystem


    default TaxSystem toModel(TaxSystemDto taxSystemDto){
        if (taxSystemDto == null) {
        return null;
    }

        return TaxSystem.builder()
                .id(taxSystemDto.getId())
                .name(taxSystemDto.getName())
                .sortNumber(taxSystemDto.getSortNumber())
            .build();
}

    default TaxSystemDto toDto(TaxSystem taxSystem) {
        TaxSystemDto taxSystemDto = new TaxSystemDto();
        if (taxSystem==null){
            return null;
        } else {
            taxSystemDto.setId(taxSystem.getId());
            taxSystemDto.setName(taxSystem.getName());
            taxSystemDto.setSortNumber(taxSystem.getSortNumber());
            return taxSystemDto;
        }
    }
}
