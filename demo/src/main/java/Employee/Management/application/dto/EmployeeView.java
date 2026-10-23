package Employee.Management.application.dto;

import Employee.Management.application.enums.EntityStatus;
import lombok.Data;

@Data
public class EmployeeView {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private EntityStatus status;
    private String companyId;
    private String siteId;

}
