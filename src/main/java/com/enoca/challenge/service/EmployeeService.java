package com.enoca.challenge.service;

import com.enoca.challenge.dto.request.CreateEmployeeRequestDto;
import com.enoca.challenge.dto.response.EmployeeResponseDto;
import com.enoca.challenge.model.Employee;
import com.enoca.challenge.repository.CompanyRepository;
import com.enoca.challenge.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public EmployeeResponseDto create(CreateEmployeeRequestDto dto) {
        Employee employee = Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
        employeeRepository.save(employee);
        return EmployeeResponseDto.fromModel(employee);
    }

    public EmployeeResponseDto getById(Long id) {
        ifExist(id);
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return EmployeeResponseDto.fromModel(employee);
    }

    public List<EmployeeResponseDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeResponseDto::fromModel).collect(Collectors.toList());
    }


    public EmployeeResponseDto update(Long id, CreateEmployeeRequestDto dto) {
        ifExist(id);
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employeeRepository.save(employee);
        return EmployeeResponseDto.fromModel(employee);
    }

    public void delete(Long id) {
        ifExist(id);
        employeeRepository.deleteById(id);
    }

    public EmployeeResponseDto addCompany(Long employeeId, Long companyId) {
        ifExist(employeeId);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setCompany(companyRepository.findById(companyId).orElseThrow());
        employeeRepository.save(employee);
        return EmployeeResponseDto.fromModel(employee);
    }

    private void ifExist(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee not found with id: " + id);
        }
    }


}
