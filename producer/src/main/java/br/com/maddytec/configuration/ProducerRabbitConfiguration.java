package br.com.maddytec.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerRabbitConfiguration {

    @Value("${fila.routing-key}")
    private String queue;

    @Value("${fila.exchange}")
    private String exchange;

    @Value("${fila.deadLetter}")
    private String deadLetter;

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    Queue deadLetter(){
        return new Queue(deadLetter);
    }

    @Bean
    Queue queue(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", exchange);
        args.put("x-dead-letter-routing-key", deadLetter);
        return new Queue(queue, true, false,false, args);
    }

    @Bean
    public Binding bindingQueue(){
        return BindingBuilder.bind(queue())
                .to(directExchange())
                .with(queue);
    }

    @Bean
    public Binding bindingDeadLetter(){
        return BindingBuilder.bind(deadLetter())
                .to(directExchange())
                .with(deadLetter);
    }

}
