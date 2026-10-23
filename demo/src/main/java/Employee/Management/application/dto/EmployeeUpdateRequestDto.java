package Employee.Management.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeUpdateRequestDto {
    private String phoneNumber;
    private String email;
}
