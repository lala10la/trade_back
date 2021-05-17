package com.trade_accounting.services.interfaces;

import com.trade_accounting.models.Employee;
import com.trade_accounting.models.dto.EmployeeDto;
import com.trade_accounting.models.dto.PageDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface EmployeeService extends SearchableService<Employee, EmployeeDto>, AbstractService<EmployeeDto> {

    List<EmployeeDto> getAll();

    PageDto<EmployeeDto> search(Specification<Employee> specification, Pageable page);

    EmployeeDto getById(Long id);

    void deleteById(Long id);

    EmployeeDto getByEmail(String email);
}
