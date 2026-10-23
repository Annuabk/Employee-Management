package Employee.Management.application.adapter;

import Employee.Management.application.entity.Employee;
import Employee.Management.application.misc.EmployeeFilter;
import Employee.Management.application.port.spi.EmployeePersistencePort;
import Employee.Management.application.repository.EmployeeRepository;
import Employee.Management.application.specification.EmployeeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeAdapter extends EmployeeSpecification<Employee>
        implements EmployeePersistencePort{
    private  final EmployeeRepository repository;


    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Employee get(Long id) {
        return repository.findById(id).orElse(null);}

        @Override
        public List<Employee> getList(EmployeeFilter filter) {
            Specification<Employee> specification = Specification
                    .where(query(filter.getQuery()))
                    .and(entityStatus(filter.getStatuses()))
                    .and(companyId(filter.getCompanyId()))
                    .and(siteId(filter.getSiteId()));
            return repository.findAll(specification);
        }

    @Override
    public Page<Employee> getPaginated(EmployeeFilter filter, Pageable pageable) {
        Specification<Employee> specification = Specification
                .where(query(filter.getQuery()))
                .and(entityStatus(filter.getStatuses()))
                .and(companyId(filter.getCompanyId()))
                            .and(siteId(filter.getSiteId()));
        return repository.findAll(specification, pageable);
    }
    }


