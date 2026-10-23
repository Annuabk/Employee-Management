package Employee.Management.application.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends RuntimeException {


        private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        public EmployeeNotFoundException(Long id) {
            super("Employee not found with id: " + id);
        }
    }
