package com.controller;

import com.domain.Employee;
import com.service.RabbitMqSender;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RabbitMqController {

    private final RabbitMqSender rabbitMqSender;

    @PostMapping("/producer")
    public String producer(@RequestBody Employee employee) {
        rabbitMqSender.send(employee);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
