package org.cmp.service;

import org.cmp.dto.Employee;
import org.cmp.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    List<EmployeeEntity> getAll();
}
