package org.cmp.controller;

import lombok.RequiredArgsConstructor;
import org.cmp.dto.Employee;
import org.cmp.entity.EmployeeEntity;
import org.cmp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    final EmployeeService service;

    @PostMapping("add-employee")
    public void addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
    }

    @GetMapping("get-all")
    public List<EmployeeEntity> getAll(){
        return service.getAll();
    }

}
