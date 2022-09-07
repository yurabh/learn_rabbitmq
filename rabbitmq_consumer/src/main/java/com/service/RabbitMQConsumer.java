package com.service;

import com.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receivedMessage(Employee employee) {
        System.out.println("Message From RabbitMQ: " + employee);
    }
}
