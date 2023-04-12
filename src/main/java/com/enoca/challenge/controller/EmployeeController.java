package com.enoca.challenge.controller;

import com.enoca.challenge.dto.request.CreateOrUpdateEmployeeRequestDto;
import com.enoca.challenge.dto.response.EmployeeResponseDto;
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
    public EmployeeResponseDto create(@RequestBody CreateOrUpdateEmployeeRequestDto dto) {
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

    @GetMapping("/firstName/{firstName}")
    public List<EmployeeResponseDto> getAllByFirstName(@PathVariable String firstName) {
        return employeeService.getAllByFirstName(firstName);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDto update(@PathVariable Long id, @RequestBody CreateOrUpdateEmployeeRequestDto dto) {
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
