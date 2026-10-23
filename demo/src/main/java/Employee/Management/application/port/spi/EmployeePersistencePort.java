package Employee.Management.application.port.spi;

import Employee.Management.application.entity.Employee;
import Employee.Management.application.misc.EmployeeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeePersistencePort {
    void save(Employee employee);

    Employee get(Long id);

    List<Employee> getList(EmployeeFilter filter);

    Page<Employee> getPaginated(EmployeeFilter filter, Pageable pageable);
}
