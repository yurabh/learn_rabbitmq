package com.service;

import com.domain.Employee;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqSender {

    private final AmqpTemplate rabbitTemplate;

    public void send(String exchange, String routingKey, Employee employee) {
        rabbitTemplate.convertAndSend(exchange, routingKey, employee);
        System.out.println("Send message:" + employee);
    }
}
