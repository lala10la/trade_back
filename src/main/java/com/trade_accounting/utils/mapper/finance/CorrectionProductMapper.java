package com.trade_accounting.utils.mapper.finance;

import com.trade_accounting.models.entity.finance.CorrectionProduct;
import com.trade_accounting.models.dto.finance.CorrectionProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CorrectionProductMapper {
    //CorrectionProduct
    CorrectionProduct toModel(CorrectionProductDto correctionDto);

    @Mappings({
            @Mapping(source = "product.id", target = "productId")
    })
    CorrectionProductDto toDto(CorrectionProduct correction);
}
