package com.algaworks.algasensors.temperature.processing.infrastructure.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Apenas um exemplo, em um ambiente real, as queues e exchanges não seriam criadas diretamente na aplicação,
// mas sim em um ambiente de infraestrutura, como o RabbitMQ Management ou usando ferramentas de infraestrutura como
// código (IaC) como Terraform ou Ansible.
@Configuration
public class RabbitMQConfig {

    public static final String FANOUT_EXCHANGE_NAME = "temperature-processing.temperature-received.v1.e";

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);

        // Exemplos de IA
//        rabbitAdmin.declareQueue(new org.springframework.amqp.core.Queue("temperature.readings.queue"));
//        rabbitAdmin.declareExchange(new org.springframework.amqp.core.DirectExchange("temperature.exchange"));
//        rabbitAdmin.declareBinding(
//                org.springframework.amqp.core.BindingBuilder.bind(
//                        new org.springframework.amqp.core.Queue("temperature.readings.queue"))
//                        .to(new org.springframework.amqp.core.DirectExchange("temperature.exchange"))
//                        .with("temperature.readings.routingkey")
//        );
        return rabbitAdmin;
    }

    @Bean
    public FanoutExchange exchange() {
        return ExchangeBuilder.fanoutExchange(FANOUT_EXCHANGE_NAME).build();
    }

}
