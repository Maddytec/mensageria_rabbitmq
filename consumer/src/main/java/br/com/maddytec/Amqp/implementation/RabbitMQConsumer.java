package br.com.maddytec.Amqp.implementation;

import br.com.maddytec.Amqp.AmqpConsumer;
import br.com.maddytec.dto.Message;
import br.com.maddytec.service.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {

    @Autowired
    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${fila.routing-key}")
    public void consumer(Message message) {
        consumerService.action(message);
    }
}
