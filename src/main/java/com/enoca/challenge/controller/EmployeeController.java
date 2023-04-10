package com.enoca.challenge.controller;

import com.enoca.challenge.dto.request.CreateEmployeeRequestDto;
import com.enoca.challenge.dto.response.EmployeeResponseDto;
import com.enoca.challenge.model.Employee;
import com.enoca.challenge.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/api/employee")
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponseDto create(@RequestBody CreateEmployeeRequestDto dto) {
        return employeeService.create(dto);

    }

    @GetMapping
    public List<EmployeeResponseDto> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDto update(@PathVariable Long id, @RequestBody CreateEmployeeRequestDto dto) {
        return employeeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("Employee deleted.");
    }

    @PostMapping("/{employeeId}/company/{companyId}")
    public EmployeeResponseDto addCompany(@PathVariable Long employeeId, @PathVariable Long companyId) {
        return employeeService.addCompany(employeeId, companyId);
    }
}
