package com.trade_accounting.utils.mapper.warehouse;

import com.trade_accounting.models.dto.warehouse.ShipmentDto;
import com.trade_accounting.models.entity.warehouse.Shipment;
import com.trade_accounting.models.entity.warehouse.ShipmentProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {
    //Shipment
    @Mapping(source = "date", target = "date", dateFormat = "dd-MM-yyyy HH:mm")
    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "contractorId", target = "contractor.id")
    @Mapping(source = "warehouseId", target = "warehouse.id")
    @Mapping(target = "shipmentProducts", source = "shipmentProductsIds")
    Shipment toModel(ShipmentDto emp);

    @Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy HH:mm")
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "contractorId", source = "contractor.id")
    @Mapping(target = "warehouseId", source = "warehouse.id")
    @Mapping(target = "shipmentProductsIds", source = "shipmentProducts")
    ShipmentDto toDto(Shipment shipment);

    default Long shipmentProductToLong(ShipmentProduct shipmentProduct) {
        return shipmentProduct.getId();
    }

    default ShipmentProduct longToShipmentProduct(Long id) {
        return ShipmentProduct.builder()
                .id(id)
                .build();
    }

}
