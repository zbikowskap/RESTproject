package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EmployeeService {

    public final EmployeeRepository employeeRepository;

    public List<Employee> getAll() {

        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Brak takiego id" + id)); //zwraca optional i żeby ogarnąć go trzeba kazac mu wyrzucić wyjątek
    }
// poniżej kożystamy z DTO nie podajemy przy tworzeniu id samo ma sobie nadać
    public void createEmployee(Employee employee) {
        Employee newEmployee = Employee.builder()
                .name(employee.getName())
                .lastName(employee.getLastName())
                .position(employee.getPosition())
                .build();
        employeeRepository.save(newEmployee);
    }

    public void deleteById(Long id) {
        getById(id); //ma sprawdzić czy napewni jest takie id i jak nie ma wpaśc w wyjatek
        employeeRepository.deleteById(id);
    }

    public Employee update(Long id, Employee employee) {
        Employee oldEmployee = getById(id);
        Employee newEmployee = Employee.builder()
                .id(id)
                .name(employee.getName())
                .lastName(employee.getLastName())
                .position(employee.getPosition())
                .build();
        return employeeRepository.save(newEmployee);
    }
}
