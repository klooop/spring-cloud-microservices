package com.javastart.notification.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class RabbitMQConfig {
    public static  final String QUEUE_DEPOSIT = "js.deposit.notify";
    public   static final String TOPIC_EXCHANGE_DEPOSIT = "js.deposit.notify.exchange";
    public static final String ROUTING_KEY_DEPOSIT = "js.key.deposit";

    // чтобы спрингбут приложение 100 процентов создало queue, exchange
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Bean
    public TopicExchange depositExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_DEPOSIT);
    }
    @Bean
    public Queue queueDeposit() {
        return new Queue(QUEUE_DEPOSIT);
    }

    // связываем queue, exchange, routing key
    public Binding depositBinding() {
        return BindingBuilder
                .bind(queueDeposit())
                .to(depositExchange())
                .with(ROUTING_KEY_DEPOSIT);
    }

}
