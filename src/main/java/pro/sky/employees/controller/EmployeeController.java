package pro.sky.employees.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employees.Employee;
import pro.sky.employees.EmployeeService;
import pro.sky.employees.exception.EmployeeAlreadyAddedException;
import pro.sky.employees.exception.EmployeeNotFoundException;
import pro.sky.employees.exception.EmployeeStorageIsFullException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @PostMapping ("/add")
    //По адресу /employee/add?firstName=Ivan&lastName=Ivanov
    // должен вернуться объект Employee в формате JSON,
    // т. е. { "firstName": "Ivan", "lastName": "Ivanov" },
    // или исключение ArrayIsFull в случае переполнения массива или EmployeeAlreadyAdded
    // в случае, когда сотрудник уже существует.
    public Employee addEmployee (@RequestParam String firstName, @RequestParam String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        return employeeService.addEmployee(firstName, lastName);
    }

    //По адресу /employee/remove?firstName=Ivan&lastName=Ivanov
    // должен вернуться объект Employee
    // в формате JSON, т. е. { "firstName": "Ivan", "lastName": "Ivanov" },
    // или исключение со статусом EmployeeNotFound, если сотрудник отсутствует.

    @DeleteMapping("/remove")
    public Employee removeEmployee (@RequestParam String firstName, @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.deleteEmployee(firstName, lastName);
    }
    //По адресу /employee/find?firstName=Ivan&lastName=Ivanov
    // должен вернуться объект Employee в формате JSON,
    // т. е. { "firstName": "Ivan", "lastName": "Ivanov" },
    // или исключение со статусом EmployeeNotFound, если такой сотрудник отсутствует

    @GetMapping("/find")
    public Employee findEmployee (@RequestParam String firstName, @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.findEmployee(firstName, lastName);
    }



    private EmployeeService employeeService;
    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/findAll")
    public List<Employee> findAll () {
        return employeeService.findAllEmployees();
    }





}
