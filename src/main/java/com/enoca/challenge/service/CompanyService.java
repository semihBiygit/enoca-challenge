package com.enoca.challenge.service;

import com.enoca.challenge.dto.request.CreateOrUpdateCompanyRequestDto;
import com.enoca.challenge.dto.response.CompanyResponseDto;
import com.enoca.challenge.exception.custom.CompanyNotFoundException;
import com.enoca.challenge.model.Company;
import com.enoca.challenge.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public CompanyResponseDto create(CreateOrUpdateCompanyRequestDto dto) {
        Company company = Company.builder()
                .name(dto.getName())
                .build();
        companyRepository.save(company);
        return CompanyResponseDto.fromModel(company);
    }

    public List<CompanyResponseDto> getAll() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(CompanyResponseDto::fromModel).collect(Collectors.toList());
    }

    public CompanyResponseDto getById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() ->
                new CompanyNotFoundException("Company not found with id: " + id));
        return CompanyResponseDto.fromModel(company);
    }

    public CompanyResponseDto getByName(String name) {
        Company company = companyRepository.findByNameIgnoreCase(name).orElseThrow(() ->
                new CompanyNotFoundException("Company not found with name: " + name));
        return CompanyResponseDto.fromModel(company);
    }

    @Transactional
    public CompanyResponseDto update(Long id, CreateOrUpdateCompanyRequestDto dto) {
        Company company = companyRepository.findById(id).orElseThrow(() ->
                new CompanyNotFoundException("Company not found with id: " + id));
        company.setName(dto.getName());
        companyRepository.save(company);
        return CompanyResponseDto.fromModel(company);
    }

    @Transactional
    public void delete(Long id) {
        ifExist(id);
        companyRepository.deleteById(id);
    }

    private void ifExist(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new CompanyNotFoundException("Company not found with id: " + id);
        }
    }

}