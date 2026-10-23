package Employee.Management.application.port.api;

import Employee.Management.application.dto.EmployeeCreateRequestDto;
import Employee.Management.application.dto.EmployeeUpdateRequestDto;
import Employee.Management.application.dto.EmployeeView;
import Employee.Management.application.misc.EmployeeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeServicePort {
    EmployeeView create(EmployeeCreateRequestDto requestDto);

    EmployeeView get(Long id);

    EmployeeView update(EmployeeUpdateRequestDto requestDto, Long id);

    void delete(Long id);

    List<EmployeeView> getList(EmployeeFilter filter);

    Page<EmployeeView> get(EmployeeFilter filter, Pageable pageable);
}
