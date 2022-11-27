package pro.sky.employees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends Exception {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
