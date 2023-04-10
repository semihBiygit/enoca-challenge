package com.enoca.challenge.service;

import com.enoca.challenge.dto.request.CreateCompanyRequestDto;
import com.enoca.challenge.dto.response.CompanyResponseDto;
import com.enoca.challenge.model.Company;
import com.enoca.challenge.repository.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyResponseDto create(CreateCompanyRequestDto dto) {
        Company company = Company.builder()
                .name(dto.getName())
                .build();
        companyRepository.save(company);
        return CompanyResponseDto.fromModel(company);
    }

    public CompanyResponseDto getById(Long id) {
        ifExist(id);
        Company company = companyRepository.findById(id).orElse(null);
        return CompanyResponseDto.fromModel(company);
    }

    public List<CompanyResponseDto> getAll() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(CompanyResponseDto::fromModel).collect(Collectors.toList());
    }


    public CompanyResponseDto update(Long id, CreateCompanyRequestDto dto) {
        ifExist(id);
        Company company = companyRepository.findById(id).orElseThrow();
        company.setName(dto.getName());
        companyRepository.save(company);
        return CompanyResponseDto.fromModel(company);
    }

    public void delete(Long id) {
        ifExist(id);
        companyRepository.deleteById(id);
    }

    private void ifExist(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new EntityNotFoundException("Company not found with id: " + id);
        }
    }
}
