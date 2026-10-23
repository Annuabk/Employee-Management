package Employee.Management.application.misc;

import Employee.Management.application.enums.EntityStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;


@Getter
@Setter
public class EmployeeFilter {

    private String name;
    private EntityStatus[] statuses;
    private String companyId;
    private String siteId;


    @PositiveOrZero
    private int page = 0;

    @Min(1)
    @Max(100)
    private int rows = 15;

    private String query;


    private String sortBy;

    private Sort.Direction sortIn = Sort.Direction.DESC;


    public EntityStatus[] getStatuses() {
        return statuses == null || statuses.length == 0 ? new EntityStatus[]{EntityStatus.ACTIVE} : statuses;
    }


}

