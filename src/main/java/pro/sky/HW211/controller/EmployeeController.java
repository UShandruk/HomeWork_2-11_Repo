package pro.sky.HW211.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HW211.model.Employee;
import pro.sky.HW211.service.EmployeeService;

import java.time.LocalDateTime;


@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    // Конструктор
    public EmployeeController(EmployeeService counterService) {
        this.employeeService = counterService;
    }

    @GetMapping
    public String hello() {
        return "Hello, world!" + "\\r\\n " + LocalDateTime.now();
    }

    // http://localhost:8080/greetings?name=Лев&lastName=Толстой // "Здравствуйте, Лев Толстой!";
    @GetMapping("/greetings")
    public String greetings(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        return "Здравствуйте, " + name + " " + lastName + "!";
    }
/*
    // http://localhost:8080/greetings?name=Лев&lastName=Толстой // "Здравствуйте, Лев Толстой!";
    @GetMapping("/greetings/add")
    public String greetings_add(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        return "Здравствуйте, " + name + " " + lastName + "!";
    }
*/


    // http://localhost:8080/employee/add?firstName=Лев&lastName=Толстой // {"firstName": "Лев", "lastName": "Толстой"}
    //@GetMapping("/employee/add") - не работает
    @GetMapping("/employeeadd")
    public String getEmployeeByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws Exception
    {
        String result = employeeService.addEmployee(firstName, lastName);
        return result;
    }


    // http://localhost:8080/employee/remove?firstName=Лев&lastName=Толстой // {"firstName": "Лев", "lastName": "Толстой"}
    //@GetMapping("/employee/remove") - не работает?
    @GetMapping("/employeeremove")
    public String removeEmployeeByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws Exception
    {
        String result = employeeService.removeEmployee(firstName, lastName);
        return result;
    }
}