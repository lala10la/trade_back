package com.trade_accounting.utils.mapper;

import com.trade_accounting.models.Company;
import com.trade_accounting.models.RetailSales;
import com.trade_accounting.models.RetailShift;
import com.trade_accounting.models.RetailStore;
import com.trade_accounting.models.Warehouse;
import com.trade_accounting.models.dto.RetailSalesDto;
import com.trade_accounting.models.dto.RetailShiftDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface RetailShiftMapper {

        /*@Mappings({
                @Mapping(source = "retailStore.id", target = "retailStoreId"),
                @Mapping(source = "warehouse.id", target = "warehouseId"),
                @Mapping(source = "company.id", target = "companyId")
    })
        RetailShiftDto toDto(RetailShift retailShift);


    @Mappings({
            @Mapping(source = "retailStoreId", target = "retailStore.id"),
            @Mapping(source = "warehouseId", target = "warehouse.id"),
            @Mapping(source = "companyId", target = "company.id")

    })
    RetailShift toModel(RetailShiftDto retailShiftDto);*/

    default RetailShiftDto toDto(RetailShift retailShift) {
        if ( retailShift == null ) {
            return null;
        }

        RetailShiftDto.RetailShiftDtoBuilder retailShiftDto = RetailShiftDto.builder();

        retailShiftDto.retailStoreId( retailShiftRetailStoreId( retailShift ) );
        retailShiftDto.warehouseId( retailShiftWarehouseId( retailShift ) );
        retailShiftDto.companyId( retailShiftCompanyId( retailShift ) );
        retailShiftDto.id( retailShift.getId() );
        retailShiftDto.dataOpen( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(retailShift.getDataOpen()) );
        System.out.println(retailShift.getDataOpen());
        System.out.println(retailShift.getDataClose());
        if (retailShift.getDataClose() != null) {
            retailShiftDto.dataClose( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(retailShift.getDataClose()) );
        } else {
            retailShiftDto.dataClose( null );
        }
        retailShiftDto.bank( retailShift.getBank() );
        retailShiftDto.revenuePerShift( retailShift.getRevenuePerShift() );
        retailShiftDto.received( retailShift.getReceived() );
        retailShiftDto.amountOfDiscounts( retailShift.getAmountOfDiscounts() );
        retailShiftDto.commission_amount( retailShift.getCommission_amount() );
        retailShiftDto.sent( retailShift.getSent() );
        retailShiftDto.printed( retailShift.getPrinted() );
        retailShiftDto.comment( retailShift.getComment() );

        return retailShiftDto.build();
    }

    default RetailShift toModel(RetailShiftDto retailShiftDto) {
        if ( retailShiftDto == null ) {
            return null;
        }

        RetailShift.RetailShiftBuilder retailShift = RetailShift.builder();

        /*retailShift.retailStore( retailShiftDtoToRetailStore( retailShiftDto ) );
        retailShift.warehouse( retailShiftDtoToWarehouse( retailShiftDto ) );
        retailShift.company( retailShiftDtoToCompany( retailShiftDto ) );*/
        retailShift.id( retailShiftDto.getId() );
        /*retailShift.dataOpen( retailShiftDto.getDataOpen() );
        retailShift.dataClose( retailShiftDto.getDataClose() );*/
        retailShift.bank( retailShiftDto.getBank() );
        retailShift.revenuePerShift( retailShiftDto.getRevenuePerShift() );
        retailShift.received( retailShiftDto.getReceived() );
        retailShift.amountOfDiscounts( retailShiftDto.getAmountOfDiscounts() );
        retailShift.commission_amount( retailShiftDto.getCommission_amount() );
        retailShift.sent( retailShiftDto.getSent() );
        retailShift.printed( retailShiftDto.getPrinted() );
        retailShift.comment( retailShiftDto.getComment() );

        return retailShift.build();
    }

    private Long retailShiftRetailStoreId(RetailShift retailShift) {
        if ( retailShift == null ) {
            return null;
        }
        RetailStore retailStore = retailShift.getRetailStore();
        if ( retailStore == null ) {
            return null;
        }
        Long id = retailStore.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long retailShiftWarehouseId(RetailShift retailShift) {
        if ( retailShift == null ) {
            return null;
        }
        Warehouse warehouse = retailShift.getWarehouse();
        if ( warehouse == null ) {
            return null;
        }
        Long id = warehouse.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long retailShiftCompanyId(RetailShift retailShift) {
        if ( retailShift == null ) {
            return null;
        }
        Company company = retailShift.getCompany();
        if ( company == null ) {
            return null;
        }
        Long id = company.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private RetailStore retailShiftDtoToRetailStore(RetailShiftDto retailShiftDto) {
        if ( retailShiftDto == null ) {
            return null;
        }

        RetailStore.RetailStoreBuilder retailStore = RetailStore.builder();

        retailStore.id( retailShiftDto.getRetailStoreId() );

        return retailStore.build();
    }

    private Warehouse retailShiftDtoToWarehouse(RetailShiftDto retailShiftDto) {
        if ( retailShiftDto == null ) {
            return null;
        }

        Warehouse.WarehouseBuilder warehouse = Warehouse.builder();

        warehouse.id( retailShiftDto.getWarehouseId() );

        return warehouse.build();
    }

    private Company retailShiftDtoToCompany(RetailShiftDto retailShiftDto) {
        if ( retailShiftDto == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( retailShiftDto.getCompanyId() );

        return company;
    }
}