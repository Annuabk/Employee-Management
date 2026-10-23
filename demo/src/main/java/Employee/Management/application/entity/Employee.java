package Employee.Management.application.entity;

import Employee.Management.application.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Employee_details")
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private EntityStatus status;
    private String companyId;
    private String siteId;

}
