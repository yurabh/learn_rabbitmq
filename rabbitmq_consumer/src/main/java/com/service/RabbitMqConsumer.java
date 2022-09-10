package com.service;

import com.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.finance}")
    public void receivedMessage(Employee employee) {
        System.out.println("Message From RabbitMQ: finance queue " + employee);
    }

    @RabbitListener(queues = "${rabbitmq.queue.marketing}")
    public void receivedMessageOne(Employee employee) {
        System.out.println("Message From RabbitMQ: marketing queue" + employee);
    }

    @RabbitListener(queues = "${rabbitmq.queue.admin}")
    public void receivedMessageTwo(Employee employee) {
        System.out.println("Message From RabbitMQ: admin queue" + employee);
    }

    @RabbitListener(queues = "${rabbitmq.queue.all}")
    public void receivedMessageAll(Employee employee) {
        System.out.println("Message From RabbitMQ: all queue" + employee);
    }
}
