package pro.sky.HW211.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import pro.sky.HW211.service.CounterService;

@RestController
public class CommonController {
//    private final CounterService counterService;

 /*   public CommonController(CounterService counterService) {
        this.counterService = counterService;
    }*/

    @GetMapping
    public String hello() {
        return "Hello, world!";
    }

    // 1. Получить список всех сотрудников
    @GetMapping("/get-the-list-of-all-employees")
    public String getEmployeesList() {
        return "Список сотрудников.";
    }

    // 2. Посчитать сумму затрат на ЗП
    @GetMapping("/get-the-amount-of-salary-costs")
    public String getTheAmountOfSalaryCosts() {
        return "Сумма затрат на ЗП.";
    }

    // 3. Найти сотрудника с минимальной ЗП
    @GetMapping("/get-the-employee-with-minimal-salary")
    public String getTheEmployeeWithMinimalSalary() {
        return "Сотрудник с минимальной ЗП.";
    }

    // 4. Найти сотрудника с максимальной ЗП
    @GetMapping("/get-the-employee-with-maximal-salary")
    public String getTheEmployeeWithMaximalSalary() {
        return "Сотрудник с максимальной ЗП.";
    }

    // 5. Подсчитать среднее значение зарплат
    @GetMapping("/get-the-average-salary-value")
    public String getTheAverageSalaryValue() {
        return "Среднее значение зарплат.";
    }

/*
    @GetMapping("/counter")
    public String count() {
        counterService.countdown();
        return "Количество запросов: " + counterService.getCount();
    }
*/
    @GetMapping("/greetings")
    public String greetings(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        return "Здравствуйте, " + name + " " + lastName + "!";
    }
}
