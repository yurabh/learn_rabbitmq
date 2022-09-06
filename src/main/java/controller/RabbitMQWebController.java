package controller;

import domain.Employee;
import org.springframework.web.bind.annotation.*;
import service.RabbitMQService;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQWebController {

    private final RabbitMQService rabbitMQservice;

    public RabbitMQWebController(RabbitMQService rabbitMQservice) {
        this.rabbitMQservice = rabbitMQservice;
    }

    @GetMapping(value = "/producer")
    public String producer(@RequestBody Employee employee) {
        rabbitMQservice.send(employee);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
