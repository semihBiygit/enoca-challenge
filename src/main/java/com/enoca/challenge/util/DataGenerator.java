package com.enoca.challenge.util;

import com.enoca.challenge.model.Company;
import com.enoca.challenge.model.Employee;
import com.enoca.challenge.repository.CompanyRepository;
import com.enoca.challenge.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public DataGenerator(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addEmployee();
        addCompany();
    }

    private void addEmployee() {
        employeeRepository.deleteAll();
        Employee employee1 = Employee.builder()
                .firstName("John")
                .lastName("Smith")
                .build();
        employeeRepository.save(employee1);
        Employee employee2 = Employee.builder()
                .firstName("Jane")
                .lastName("Doe")
                .build();
        employeeRepository.save(employee2);
        Employee employee3 = Employee.builder()
                .firstName("Jack")
                .lastName("Black")
                .build();
        employeeRepository.save(employee3);
        Employee employee4 = Employee.builder()
                .firstName("Semih")
                .lastName("Biygit")
                .build();
        employeeRepository.save(employee4);
    }

    private void addCompany() {
        companyRepository.deleteAll();
        Company company1 = Company.builder()
                .name("Enoca")
                .build();
        companyRepository.save(company1);
        Company company2 = Company.builder()
                .name("Google")
                .build();
        companyRepository.save(company2);
        Company company3 = Company.builder()
                .name("Apple")
                .build();
        companyRepository.save(company3);
        Company company4 = Company.builder()
                .name("Microsoft")
                .build();
        companyRepository.save(company4);
    }
}
