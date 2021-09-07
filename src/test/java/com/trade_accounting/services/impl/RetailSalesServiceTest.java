package com.trade_accounting.services.impl;

import com.trade_accounting.models.RetailSales;
import com.trade_accounting.models.dto.RetailSalesDto;
import com.trade_accounting.models.dto.RetailStoreDto;
import com.trade_accounting.repositories.CompanyRepository;
import com.trade_accounting.repositories.ContractorRepository;
import com.trade_accounting.repositories.RetailSalesRepository;
import com.trade_accounting.repositories.RetailStoreRepository;
import com.trade_accounting.services.impl.RetailSalesServiceImpl;
import com.trade_accounting.services.impl.Stubs.dto.RetailSalesDtoStubs;
import com.trade_accounting.services.impl.Stubs.model.RetailSalesModelStubs;
import com.trade_accounting.services.impl.Stubs.model.RetailStoreModelStubs;
import com.trade_accounting.utils.mapper.RetailSalesMapper;
import com.trade_accounting.utils.mapper.RetailStoreMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RetailSalesServiceTest {

    @Mock
    RetailSalesRepository retailSalesRepository;

    @Mock
    RetailStoreRepository retailStoreRepository;

    @Mock
    ContractorRepository contractorRepository;

    @Mock
    CompanyRepository companyRepository;

    @InjectMocks
    RetailSalesServiceImpl retailSalesService;

    @Spy
    RetailSalesMapper retailSalesMapper;

    @Test
    void getAll_shouldReturnFilledRetailSales() {
        when(retailSalesRepository.findAll()).thenReturn(
                List.of(RetailSalesModelStubs.getRetailSales(1L))
        );

        List<RetailSalesDto> list = retailSalesService.getAll();
        System.out.println(retailSalesRepository.findAll());
        System.out.println(list);
        assertNotNull(list, "failure - expected that a list of bankAccountDto not null");
        assertEquals(1, list.size(), "failure - expected that a list of bankAccountDto grater than 0");
    }

    @Test
    void getById_shouldReturnFilledRetailSales() {
        Optional<RetailSales> retailSales = java.util.Optional.of(RetailSalesModelStubs.getRetailSales(1L));
        when(retailSalesRepository.findById(anyLong())).thenReturn(retailSales);

        RetailSalesDto retailSalesDto = retailSalesService.getById(1L);
        assertEquals(1, retailSalesDto.getId());
    }

    @Test
    void create_shouldPassInstructionsSuccessfulCreate() {
        saveOrUpdate();
    }

    @Test
    void update_shouldPassInstructionsSuccessfulUpdate() {
        saveOrUpdate();
    }

    @Test
    void delete_shouldPassInstructionsSuccessfulDelete() {
        retailSalesRepository.deleteById(anyLong());
        verify(retailSalesRepository).deleteById(anyLong());
    }

    private void saveOrUpdate() {
        when(retailSalesRepository.save(any(RetailSales.class))).thenReturn(RetailSalesModelStubs.getRetailSales(1L));
        System.out.println(RetailSalesModelStubs.getRetailSales(1L));
        RetailSalesDto retailSalesDto = retailSalesService.create(RetailSalesDtoStubs.getDto(1L));
        System.out.println(retailSalesDto);
        assertEquals(1,retailSalesDto.getId());
        verify(retailSalesRepository).save(any(RetailSales.class));
    }
}