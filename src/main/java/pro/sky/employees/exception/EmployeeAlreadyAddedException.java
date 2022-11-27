package pro.sky.employees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends Exception {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
