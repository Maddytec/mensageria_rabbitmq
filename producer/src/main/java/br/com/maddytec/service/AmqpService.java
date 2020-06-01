package br.com.maddytec.service;

import br.com.maddytec.dto.Message;
import org.springframework.stereotype.Service;

public interface AmqpService {
    void sendToConsumer(Message message);

}
