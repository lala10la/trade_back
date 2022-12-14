package com.trade_accounting.utils.mapper.fias;

import com.trade_accounting.models.dto.fias.StreetDto;
import com.trade_accounting.models.entity.fias.Street;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StreetMapper {
    //Street

    @Mapping(source = "cityDto", target = "city")
    Street toModel(StreetDto streetDto);


    @Mapping(source = "city", target = "cityDto")
    StreetDto toDto(Street street);
}
