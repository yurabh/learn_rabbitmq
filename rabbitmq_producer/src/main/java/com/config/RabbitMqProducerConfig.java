package com.config;

import com.domain.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.constant.Constant.ADMIN;
import static com.constant.Constant.ADMIN_QUEUE;
import static com.constant.Constant.ALL_QUEUE;
import static com.constant.Constant.DIRECT_EXCHANGE;
import static com.constant.Constant.FANOUT_EXCHANGE;
import static com.constant.Constant.FINANCE;
import static com.constant.Constant.FINANCE_QUEUE;
import static com.constant.Constant.MARKETING;
import static com.constant.Constant.MARKETING_QUEUE;
import static com.constant.Constant.QUEUE_ADMIN;
import static com.constant.Constant.QUEUE_ALL;
import static com.constant.Constant.QUEUE_FINANCE;
import static com.constant.Constant.QUEUE_MARKETING;
import static com.constant.Constant.TOPIC_EXCHANGE;

@Configuration
public class RabbitMqProducerConfig {

    @Bean
    public Queue marketingQueue() {
        return new Queue(MARKETING_QUEUE, false);
    }

    @Bean
    public Queue financeQueue() {
        return new Queue(FINANCE_QUEUE, false);
    }

    @Bean
    public Queue adminQueue() {
        return new Queue(ADMIN_QUEUE, false);
    }

    @Bean
    public Queue allQueue() {
        return new Queue(ALL_QUEUE, false);
    }

    @Bean
    public DirectExchange exchangeDirect() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding marketingBindingDirect(Queue marketingQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(marketingQueue)
                .to(exchange)
                .with(MARKETING);
    }

    @Bean
    public Binding financeBindingDirect(Queue financeQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(financeQueue)
                .to(exchange)
                .with(FINANCE);
    }

    @Bean
    public Binding adminBindingDirect(Queue adminQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(adminQueue)
                .to(exchange)
                .with(ADMIN);
    }

    @Bean
    public FanoutExchange exchangeFanout() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding marketingBindingFanout(Queue marketingQueue, FanoutExchange exchange) {
        return BindingBuilder
                .bind(marketingQueue)
                .to(exchange);
    }

    @Bean
    public Binding financeBindingFanout(Queue financeQueue, FanoutExchange exchange) {
        return BindingBuilder
                .bind(financeQueue)
                .to(exchange);
    }

    @Bean
    public Binding adminBindingFanout(Queue adminQueue, FanoutExchange exchange) {
        return BindingBuilder
                .bind(adminQueue)
                .to(exchange);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding marketingBindingTopic(Queue marketingQueue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(marketingQueue)
                .to(topicExchange)
                .with(QUEUE_MARKETING);
    }

    @Bean
    public Binding financeBindingTopic(Queue financeQueue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(financeQueue)
                .to(topicExchange)
                .with(QUEUE_FINANCE);
    }

    @Bean
    public Binding adminBindingTopic(Queue adminQueue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(adminQueue)
                .to(topicExchange)
                .with(QUEUE_ADMIN);
    }

    @Bean
    public Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(allQueue)
                .to(topicExchange)
                .with(QUEUE_ALL);
    }

    @Bean
    public MessageConverter converter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        DefaultClassMapper mapper = new DefaultClassMapper();
        mapper.setDefaultType(Employee.class);
        converter.setClassMapper(mapper);
        return converter;
    }

    @Bean("rabbitMq")
    public AmqpTemplate rabbitTemplateOne(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}