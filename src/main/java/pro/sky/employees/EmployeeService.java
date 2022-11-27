package pro.sky.employees;

import org.springframework.stereotype.Service;
import pro.sky.employees.exception.EmployeeAlreadyAddedException;
import pro.sky.employees.exception.EmployeeNotFoundException;
import pro.sky.employees.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    //Employee[] employees = new Employee[10];
    List<Employee> employees = new ArrayList<>();





    public Employee addEmployee (String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        boolean employeeIsFound = false;
        try {
            if (findEmployee(firstName, lastName) != null) {
                employeeIsFound = true;
            }
        } catch (EmployeeNotFoundException e) {
        }

        if (!employeeIsFound) throw new EmployeeAlreadyAddedException("Сотрудник уже есть");
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) == null) {
                employees.add(i, new Employee(lastName, firstName));
                return employees.get(i);
            }
        }
        throw new EmployeeStorageIsFullException ("В массиве нет места для добавления");
    }



    public Employee deleteEmployee (String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                Employee employeeToDelete = employees.get(i);
                employees.add(i, null);
                return employeeToDelete;
            }

        }
        throw new EmployeeNotFoundException ("Такой человек не найден");
    }

    public Employee findEmployee (String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                Employee employeeToFind = employees.get(i);
                return employeeToFind;
            }

        }
        throw new EmployeeNotFoundException ("Такой человек не найден");
    }


    public List<Employee> findAllEmployees() {
        return employees;
    }
}
