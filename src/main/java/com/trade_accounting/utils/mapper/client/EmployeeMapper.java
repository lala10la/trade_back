package com.trade_accounting.utils.mapper.client;

import com.trade_accounting.models.entity.client.Employee;
import com.trade_accounting.models.dto.client.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    //Employee
    Employee toModel(EmployeeDto employeeDto);
    @Mapping(target = "positionDtoId", source = "employee.position.id")
    @Mapping(target = "departmentDtoId", source = "employee.department.id")
    @Mapping(target = "imageDtoId", source = "employee.image.id")
    EmployeeDto toDto(Employee employee);
}
