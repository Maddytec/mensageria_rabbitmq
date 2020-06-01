package br.com.maddytec.service.implementation;

import br.com.maddytec.amqp.AmqpProducer;
import br.com.maddytec.dto.Message;
import br.com.maddytec.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<Message> amqp;

    @Override
    public void sendToConsumer(Message message) {
        amqp.producer(message);
    }
}
