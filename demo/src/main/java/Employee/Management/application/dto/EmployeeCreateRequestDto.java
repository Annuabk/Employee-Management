package Employee.Management.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCreateRequestDto {

    @NotBlank(message = "Name is required")
    private String name;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phoneNumber;
    private String email;
    @NotNull
    private String companyId;
    private String siteId;
}
