package org.cmp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.cmp.dto.Employee;
import org.cmp.entity.EmployeeEntity;
import org.cmp.repository.EmployeeRepository;
import org.cmp.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public List<EmployeeEntity> getAll() {
        return repository.findAll();
    }
}
