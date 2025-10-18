package com.acme.orders.mappper;

import com.acme.orders.api.dto.OrderCreateDto;
import com.acme.orders.api.dto.OrderResponseDto;
import com.acme.orders.entity.Order;
import com.acme.orders.entity.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "status", source = "status", qualifiedByName = "statusToString")
    OrderResponseDto toResponseDto(Order order);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "createdAt", ignore = true)
    Order toEntity(OrderCreateDto dto);

    static String statusToString(OrderStatus status){
        return status != null ? status.name() : null;
    }
}
