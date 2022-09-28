package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // ma Response body i nie trzeba go dodawać nad metodami
@RequiredArgsConstructor
@RequestMapping(path = "/employees") // dzięki temu nie musimy poawać całych ścieżek przy każdej metodzie
public class EmployeeController {
        // tu wstrzykujemi DI zależność od Servicu
    private final EmployeeService employeeService;

    @GetMapping
    //dzięki temu zwraca w json treśc wysłaną dzięki temu bezpośrednio zwracamy listę
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    //dzięki temu zwraca w json treśc wysłaną dzięki temu bezpośrednio zwracamy listę
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);

    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);

    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

}
