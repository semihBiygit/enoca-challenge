package com.enoca.challenge.dto.response;

import com.enoca.challenge.model.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResponseDto {
    private Long id;
    private String name;
    private List<EmployeeResponseDto> employees;

    public static CompanyResponseDto fromModel(Company company) {
        return company == null ? null : CompanyResponseDto.builder()
                .id(company.getId())
                .name(company.getName())
                .employees(company.getEmployees() == null ? new ArrayList<>() :
                        company.getEmployees()
                                .stream()
                                .map(EmployeeResponseDto::fromModel)
                                .collect(Collectors.toList()))
                .build();
    }
}
