package com.trade_accounting.utils.mapper.company;

import com.trade_accounting.models.entity.company.Company;
import com.trade_accounting.models.entity.company.Contract;
import com.trade_accounting.models.entity.company.Contractor;
import com.trade_accounting.models.entity.company.SupplierAccount;
import com.trade_accounting.models.entity.invoice.TypeOfInvoice;
import com.trade_accounting.models.entity.warehouse.Warehouse;
import com.trade_accounting.models.dto.company.SupplierAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface SupplierAccountMapper {
    //Supplier
    @Mapping(target = "date", ignore = true)
    SupplierAccount toModel(SupplierAccountDto supplierAccountDto);

    SupplierAccountDto toDto(SupplierAccount supplierAccount);
}
