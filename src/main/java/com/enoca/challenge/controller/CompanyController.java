package com.enoca.challenge.controller;

import com.enoca.challenge.dto.request.CreateOrUpdateCompanyRequestDto;
import com.enoca.challenge.dto.response.CompanyResponseDto;
import com.enoca.challenge.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/api/company")
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public CompanyResponseDto create(@RequestBody CreateOrUpdateCompanyRequestDto dto) {
        return companyService.create(dto);
    }

    @GetMapping
    public List<CompanyResponseDto> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public CompanyResponseDto getById(@PathVariable Long id) {
        return companyService.getById(id);
    }

    @GetMapping("/name/{name}")
    public CompanyResponseDto getByName(@PathVariable String name) {
        return companyService.getByName(name);
    }

    @PutMapping("/{id}")
    public CompanyResponseDto update(@PathVariable Long id, @RequestBody CreateOrUpdateCompanyRequestDto dto) {
        return companyService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        companyService.delete(id);
        return ResponseEntity.ok("Company deleted.");
    }

}
