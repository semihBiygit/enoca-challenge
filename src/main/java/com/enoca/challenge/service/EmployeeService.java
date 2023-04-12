package com.enoca.challenge.service;

import com.enoca.challenge.dto.request.CreateOrUpdateEmployeeRequestDto;
import com.enoca.challenge.dto.response.EmployeeResponseDto;
import com.enoca.challenge.exception.custom.CompanyNotFoundException;
import com.enoca.challenge.exception.custom.EmployeeNotFoundException;
import com.enoca.challenge.model.Company;
import com.enoca.challenge.model.Employee;
import com.enoca.challenge.repository.CompanyRepository;
import com.enoca.challenge.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public EmployeeResponseDto create(CreateOrUpdateEmployeeRequestDto dto) {
        Employee employee = Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
        employeeRepository.save(employee);
        return EmployeeResponseDto.fromModel(employee);
    }

    public List<EmployeeResponseDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeResponseDto::fromModel).collect(Collectors.toList());
    }

    public EmployeeResponseDto getById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found with id: " + id));
        return EmployeeResponseDto.fromModel(employee);
    }

    public List<EmployeeResponseDto> getAllByFirstName(String firstName) {
        List<Employee> employees = employeeRepository.findAllByFirstNameIgnoreCase(firstName).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found with firstName: " + firstName));
        return employees.stream().map(EmployeeResponseDto::fromModel).collect(Collectors.toList());
    }

    @Transactional
    public EmployeeResponseDto update(Long id, CreateOrUpdateEmployeeRequestDto dto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found with id: " + id));
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employeeRepository.save(employee);
        return EmployeeResponseDto.fromModel(employee);
    }

    public void delete(Long id) {
        ifExist(id);
        employeeRepository.deleteById(id);
    }

    @Transactional
    public EmployeeResponseDto addCompany(Long employeeId, Long companyId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found with id: " + employeeId));
        Company company = companyRepository.findById(companyId).orElseThrow(() ->
                new CompanyNotFoundException("Company not found with id: " + companyId));
        employee.setCompany(company);
        employeeRepository.save(employee);
        return EmployeeResponseDto.fromModel(employee);
    }

    private void ifExist(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
    }

}