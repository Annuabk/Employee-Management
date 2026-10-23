package Employee.Management.application.controller;

import Employee.Management.application.dto.EmployeeCreateRequestDto;
import Employee.Management.application.dto.EmployeeUpdateRequestDto;
import Employee.Management.application.dto.EmployeeView;
import Employee.Management.application.misc.EmployeeFilter;
import Employee.Management.application.port.api.EmployeeServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/employees")
@RequiredArgsConstructor
@RestControllerAdvice
public class EmployeeController {

    private final EmployeeServicePort employeeService;

    @PostMapping
    public ResponseEntity<EmployeeView> create(@RequestBody @Valid EmployeeCreateRequestDto request) {
        EmployeeView employeeView = employeeService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeView);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeView> get(@PathVariable("id") Long id) {
        EmployeeView employeeView = employeeService.get(id);
        return ResponseEntity.ok(employeeView);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeView> update(@PathVariable("id") Long id,
                                               @RequestBody @Valid EmployeeUpdateRequestDto request) {
        EmployeeView employeeView = employeeService.update(request,id);
        return ResponseEntity.ok(employeeView);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @PostMapping("search")
    public ResponseEntity<List<EmployeeView>> getList(@Valid @RequestBody EmployeeFilter filter) {
        List<EmployeeView> employeeViews = employeeService.getList(filter);
        return ResponseEntity.ok(employeeViews);
    }


    @GetMapping
    public Page<EmployeeView> get(EmployeeFilter filter, @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        return employeeService.get(filter, pageable);
    }
}