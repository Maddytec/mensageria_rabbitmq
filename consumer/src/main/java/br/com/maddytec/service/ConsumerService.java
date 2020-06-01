package br.com.maddytec.service;

import br.com.maddytec.dto.Message;

public interface ConsumerService {

    void action(Message message) throws Exception;
}
