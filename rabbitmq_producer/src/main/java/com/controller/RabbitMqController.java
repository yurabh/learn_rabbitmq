package com.controller;

import com.domain.Employee;
import com.service.RabbitMqSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RabbitMqController {

    private final RabbitMqSender rabbitMqSender;

    @PostMapping("/producer")
    public String producer(@RequestParam("exchangeName") String exchange,
                           @RequestParam("routingKey") String routingKey,
                           @RequestBody Employee employee) {
        rabbitMqSender.send(exchange, routingKey, employee);
        return "Message sent to the RabbitMQ";
    }
}
