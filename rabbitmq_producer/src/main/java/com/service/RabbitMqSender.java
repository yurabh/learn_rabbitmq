package com.service;

import com.domain.Employee;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

@Service
@RequiredArgsConstructor
public class RabbitMqSender {

    private final AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    public void send(Employee employee) {
        rabbitTemplate.convertAndSend(exchange, routingKey, employee);
        out.println("Send message to queue = " + employee);
    }
}
