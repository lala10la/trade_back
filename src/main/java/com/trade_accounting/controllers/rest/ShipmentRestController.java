package com.trade_accounting.controllers.rest;

import com.trade_accounting.models.Shipment;
import com.trade_accounting.models.dto.ShipmentDto;
import com.trade_accounting.repositories.ShipmentRepository;
import com.trade_accounting.services.interfaces.CheckEntityService;
import com.trade_accounting.services.interfaces.ShipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Shipment Rest Controller", description = "CRUD  операции с отгрузками")
@Api(tags = "Shipment Rest Controller")
@RequestMapping("/api/shipment")
@RequiredArgsConstructor
public class ShipmentRestController {

    private final ShipmentService shipmentService;
    private final CheckEntityService checkEntityService;
    private final ShipmentRepository shipmentRepository;

    @GetMapping
    @ApiOperation(value = "getAll", notes = "Получение списка всех отгрузок")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка отгрузок"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<ShipmentDto>> getAll() {
        List<ShipmentDto> shipmentDtoList;
        shipmentDtoList = shipmentService.getAll();
        return ResponseEntity.ok(shipmentDtoList);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById", notes = "Получение отгрузки по ее id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Отгрузка найдена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<ShipmentDto> getById(@ApiParam(name = "id", type = "Long",
            value = "Переданный в URL id, по которому необходимо найти отгрузку")
                                              @PathVariable(name = "id") Long id) {
        checkEntityService.checkExists((JpaRepository) shipmentRepository, id);
        return ResponseEntity.ok(shipmentService.getById(id));
    }

    @GetMapping("/search")
    @ApiOperation(value = "search", notes = "Получение списка счетов по заданным параметрам")
    public ResponseEntity<List<ShipmentDto>> getAll(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "date", params = "date", spec = GreaterThanOrEqual.class),
                    @Spec(path = "company.name", params = "companyDto", spec = Like.class),
                    @Spec(path = "contractor.name", params = "contractorDto", spec = LikeIgnoreCase.class),
                    @Spec(path = "warehouse.name", params = "warehouseDto", spec = LikeIgnoreCase.class),
                    @Spec(path = "sum", params = "sum", spec = Equal.class),
                    @Spec(path = "paid", params = "paid", spec = Equal.class),
                    @Spec(path = "isSpend", params = "spend", spec = Equal.class),
                    @Spec(path = "isSend", params = "send", spec = Equal.class),
                    @Spec(path = "isPrint", params = "print", spec = Equal.class),
                    @Spec(path = "comment", params = "comment", spec = Equal.class),
            }) Specification<Shipment> spec) {
        return ResponseEntity.ok(shipmentService.search(spec));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Добавление новой отгрузки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Отгрузка создана"),
            @ApiResponse(code = 201, message = "Запрос принят и отгрузка добавлена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<ShipmentDto> create(@ApiParam(name = "shipmentDto", value = "DTO отгрузки, которую необходимо создать")
                                             @RequestBody ShipmentDto shipmentDto) {
        return ResponseEntity.ok().body(shipmentService.create(shipmentDto));
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Изменение информации об отгрузке")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Информация об отгрузке обновлена"),
            @ApiResponse(code = 201, message = "Запрос принят и данные об отгрузке обновлены"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(@ApiParam(name = "shipmentDto", value = "DTO отгрузки, которую необходимо обновить")
                                    @RequestBody ShipmentDto shipmentDto) {
        return ResponseEntity.ok().body(shipmentService.update(shipmentDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление отгрузки по ее id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Отгрузка удален"),
            @ApiResponse(code = 204, message = "Запрос получен и обработан, данных для возврата нет"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", type = "Long",
            value = "Переданный в URL id по которому необходимо удалить отгрузку")
                                        @PathVariable(name = "id") Long id) {
        shipmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}