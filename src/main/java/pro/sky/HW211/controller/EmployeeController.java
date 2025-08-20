package pro.sky.HW211.controller;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HW211.service.EmployeeService;


@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService counterService) {
        this.employeeService = counterService;
    }
}
