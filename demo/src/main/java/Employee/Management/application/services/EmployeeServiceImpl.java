package Employee.Management.application.services;

import Employee.Management.application.dto.EmployeeCreateRequestDto;
import Employee.Management.application.dto.EmployeeUpdateRequestDto;
import Employee.Management.application.dto.EmployeeView;
import Employee.Management.application.entity.Employee;
import Employee.Management.application.enums.EntityStatus;
import Employee.Management.application.exception.EmployeeNotFoundException;
import Employee.Management.application.misc.EmployeeFilter;
import Employee.Management.application.mapper.EmployeeMapper;
import Employee.Management.application.port.api.EmployeeServicePort;
import Employee.Management.application.port.spi.EmployeePersistencePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeServicePort {
    private final EmployeePersistencePort  employeeJpaAdapter;
    private final EmployeeMapper mapper;


    @Override
    public EmployeeView create(EmployeeCreateRequestDto requestDto){
         Employee employee = mapper.map(requestDto);
        employeeJpaAdapter.save(employee);
        return mapper.getView(employee);
    }
    @Override
    public EmployeeView get(Long id){
        Employee employee = employeeJpaAdapter.get(id);
        if (employee == null)
            throw new EmployeeNotFoundException(id);
        return mapper.getView(employee);
    }
    @Override
    public EmployeeView update(EmployeeUpdateRequestDto requestDto, Long id){
        Employee employee = employeeJpaAdapter.get(id);
        if(employee==null)
            throw new EmployeeNotFoundException(id);
        mapper.update(requestDto,employee);
        employeeJpaAdapter.save(employee);
        return  mapper.getView(employee);
    }
    @Override
    public void delete(Long id){
        Employee employee = employeeJpaAdapter.get(id);
        if (employee == null)
            throw new EmployeeNotFoundException(id);
        employee.setStatus(EntityStatus.DELETED);
        employeeJpaAdapter.save(employee);
    }
    @Override
    public List<EmployeeView> getList(EmployeeFilter filter)
    {
        List<Employee> employeeList = employeeJpaAdapter.getList(filter);
        return mapper.getView(employeeList);
    }


    @Override
    public Page<EmployeeView> get(EmployeeFilter filter, Pageable pageable) {
        Page<Employee> employees = employeeJpaAdapter.getPaginated(filter, pageable);
        return mapper.getPaginatedViews(employees);
    }






}
