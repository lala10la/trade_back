package com.trade_accounting.utils.mapper;

import com.trade_accounting.models.Role;
import com.trade_accounting.models.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    //Role
    default RoleDto toDto(Role role) {
        RoleDto roleDto = new RoleDto();

        if(role == null) {
            return null;
        } else {
            roleDto.setId(role.getId());
            roleDto.setName(role.getName());
            roleDto.setSortNumber(role.getSortNumber());
            return roleDto;
        }
    }



    default Role toModel(RoleDto role) {
        if (role == null) {
            return null;
        }

        return Role.builder()
                .id(role.getId())
                .name(role.getName())
                .sortNumber(role.getSortNumber())
                .build();
    }
}
