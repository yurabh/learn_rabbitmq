package service;

import domain.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

@Service
public class RabbitMQService {

    private final AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public RabbitMQService(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Employee employee) {
        rabbitTemplate.convertAndSend(exchange, routingkey, employee);
        out.println("Send msg = " + employee);
    }
}
