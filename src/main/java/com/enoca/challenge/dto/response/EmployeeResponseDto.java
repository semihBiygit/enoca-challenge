package com.enoca.challenge.dto.response;

import com.enoca.challenge.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String company;

    public static EmployeeResponseDto fromModel(Employee employee) {
        String companyName = (employee.getCompany() != null) ? employee.getCompany().getName() : "Şirket Yok";
        return EmployeeResponseDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .company(companyName)
                .build();
    }

}
