package Employee.Management.application.mapper;

import Employee.Management.application.dto.EmployeeCreateRequestDto;
import Employee.Management.application.dto.EmployeeUpdateRequestDto;
import Employee.Management.application.dto.EmployeeView;
import Employee.Management.application.entity.Employee;
import org.mapstruct.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "status",constant = "ACTIVE")
    Employee map(EmployeeCreateRequestDto request);


    EmployeeView getView(Employee employee);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(EmployeeUpdateRequestDto requestDto,@MappingTarget Employee employee);

    List<EmployeeView> getView(List<Employee> meterInstruments);

    default Page<EmployeeView> getPaginatedViews(Page<Employee> employees) {
        if (employees == null) {
            return new PageImpl<>(new ArrayList<>());
        }
        return employees.map(this::getView);
    }



}



