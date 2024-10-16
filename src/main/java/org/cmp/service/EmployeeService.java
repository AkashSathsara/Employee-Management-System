package org.cmp.service;

import org.cmp.dto.Employee;
import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAll();
    void deleteEmployeeById(Long id);
    void updateEmployee(Employee employee);
    Employee findById(Long id);
    Employee findByFirstName(String firstName);
}
