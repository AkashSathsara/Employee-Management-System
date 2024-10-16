package org.cmp.controller;

import lombok.RequiredArgsConstructor;
import org.cmp.dto.Employee;
import org.cmp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    final EmployeeService service;

    @PostMapping("add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
    }

    @GetMapping("get-all")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @DeleteMapping("delete-emp/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployeeById(id);
        return "deleted";
    }

    @PostMapping("update-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateEmployee(@RequestBody Employee employee) {
        service.updateEmployee(employee);

    }

    @GetMapping("find-by-id/{id}")
    public Employee findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("find-by-firstName/{firstName}")
    public Employee findByFirstName(@PathVariable String firstName){
      return service.findByFirstName(firstName);

    }
}
