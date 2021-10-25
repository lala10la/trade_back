package com.trade_accounting.utils.mapper;

import com.trade_accounting.models.Revenue;
import com.trade_accounting.models.dto.RevenueDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface RevenueMapper {

    @Mappings({
            @Mapping(target = "product.id", source = "productId"),
            @Mapping(target = "product.description", source = "description"),
            @Mapping(target = "product.unit.id", source = "unitId"),
            @Mapping(target = "acceptanceProduction.amount", source = "amountAcceptance"),
            @Mapping(target = "acceptance.incomingNumberDate", source = "incomingNumberDate", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(target = "invoiceProduct.amount", source = "amountShipment")
    })
	Revenue toModel(RevenueDto revenueDto);

	@Mappings({
			@Mapping(source = "product.id", target = "productId"),
			@Mapping(source = "product.description", target = "description"),
			@Mapping(source = "product.unit.id", target = "unitId"),
			@Mapping(source = "acceptanceProduction.amount", target = "amountAcceptance"),
			@Mapping(source = "acceptance.incomingNumberDate", target = "incomingNumberDate", dateFormat = "yyyy-MM-dd HH:mm"),
			@Mapping(source = "invoiceProduct.amount", target = "amountShipment")
	})
	RevenueDto toDto(Revenue revenue);

}
