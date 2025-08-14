package pro.sky.HW211.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import pro.sky.HW211.service.CounterService;

@RestController
public class ExampleController {
//    private final CounterService counterService;

 /*   public ExampleController(CounterService counterService) {
        this.counterService = counterService;
    }*/

    @GetMapping
    public String hello() {
        return "Hello, world!";
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
