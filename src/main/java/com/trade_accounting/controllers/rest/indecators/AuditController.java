package com.trade_accounting.controllers.rest.indecators;

import com.trade_accounting.models.dto.client.RoleDto;
import com.trade_accounting.models.dto.indicators.AuditDto;
import com.trade_accounting.services.interfaces.indicators.AuditService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuditController {
	
	private final AuditService auditService;
	
	@ApiOperation(value = "getAll", notes = "Возвращает список всех аудитов")
	@GetMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Успешное получение списка всех аудитов"),
			@ApiResponse(code = 404, message = "Данный контролер не найден"),
			@ApiResponse(code = 403, message = "Операция запрещена"),
			@ApiResponse(code = 401, message = "Нет доступа к данной операции")}
	)
	public ResponseEntity<List<AuditDto>> getAll() {
		return ResponseEntity.ok(auditService.getAll());
	}
	
	@ApiOperation(value = "getById", notes = "Возвращает определенный аудит по Id")
	@GetMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Данный аудитов найдена"),
			@ApiResponse(code = 404, message = "Данный контролер не найден"),
			@ApiResponse(code = 403, message = "Операция запрещена"),
			@ApiResponse(code = 401, message = "Нет доступа к данной операции")}
	)
	public ResponseEntity<AuditDto> getById(@ApiParam(
			name = "id",
			type = "Long",
			value = "Переданный ID  в URL по которому необходимо найти роль",
			example = "1",
			required = true) @PathVariable("id") Long id) {
		return ResponseEntity.ok(auditService.getById(id));
	}
	
	@ApiOperation(value = "create", notes = "Создает аудит на основе переданных данных")
	@PostMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Роль успешно создана"),
			@ApiResponse(code = 201, message = "Запрос принят и данные созданы"),
			@ApiResponse(code = 401, message = "Нет доступа к данной операции"),
			@ApiResponse(code = 403, message = "Операция запрещена"),
			@ApiResponse(code = 404, message = "Данный контролер не найден")}
	)
	public ResponseEntity<?> create(@ApiParam(name = "roleDto",
			value = "DTO роли, которую необходимо создать") @RequestBody AuditDto auditDto) {
		return ResponseEntity.ok().body(auditService.create(auditDto));
	}
	
	@ApiOperation(value = "update", notes = "Обновляет аудит на основе переданных данных")
	@PutMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Роль успешно обновлена"),
			@ApiResponse(code = 201, message = "Запрос принят и данные обновлены"),
			@ApiResponse(code = 401, message = "Нет доступа к данной операции"),
			@ApiResponse(code = 403, message = "Операция запрещена"),
			@ApiResponse(code = 404, message = "Данный контролер не найден")}
	)
	public ResponseEntity<?> update(@ApiParam(name = "roleDto",
			value = "DTO роли, которую необходимо обновить")
									@RequestBody AuditDto auditDto) {
		return ResponseEntity.ok().body(auditService.update(auditDto));
	}
	
	@ApiOperation(value = "deleteById", notes = "Удаляет аудит на основе переданного ID")
	@DeleteMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Аудит успешно удален"),
			@ApiResponse(code = 204, message = "Запрос получен и обработан, данных для возврата нет"),
			@ApiResponse(code = 401, message = "Нет доступа к данной операции"),
			@ApiResponse(code = 403, message = "Операция запрещена"),
			@ApiResponse(code = 404, message = "Данный контролер не найден")}
	)
	public ResponseEntity<RoleDto> deleteById(@ApiParam(
			name = "id",
			type = "Long",
			value = "Переданный ID  в URL по которому необходимо удалить аудит",
			example = "1",
			required = true
	) @PathVariable("id") Long id) {
		auditService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
