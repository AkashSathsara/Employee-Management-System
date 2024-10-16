package org.cmp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.cmp.dto.Employee;
import org.cmp.entity.EmployeeEntity;
import org.cmp.repository.EmployeeRepository;
import org.cmp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;

    @Override
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new ObjectMapper().convertValue(employee, EmployeeEntity.class);
        repository.save(employeeEntity);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> employeeEntityList = repository.findAll();
        employeeEntityList.forEach(employeeEntity -> {
            employeeList.add(new ObjectMapper().convertValue(employeeEntity, Employee.class));
        });
        return employeeList;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (repository.findById(employee.getId()).isPresent()) {
            repository.save(new ObjectMapper().convertValue(employee, EmployeeEntity.class));
        }
    }

    @Override
    public Employee findById(Long id) {
        if (repository.findById(id).isPresent()) {
            Optional<EmployeeEntity> byId = repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(), Employee.class);
        }
        return new Employee();
    }

    @Override
    public Employee findByFirstName(String firstName) {
       return new ObjectMapper().convertValue(repository.findByFirstName(firstName), Employee.class);
    }
}
