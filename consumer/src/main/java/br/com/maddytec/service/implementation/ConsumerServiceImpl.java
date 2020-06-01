package br.com.maddytec.service.implementation;

import br.com.maddytec.dto.Message;
import br.com.maddytec.service.ConsumerService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(Message message) throws Exception {
        log.info("Message: " + message);
    }
}
