package br.com.maddytec.api;

import br.com.maddytec.dto.Message;
import br.com.maddytec.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(name = "Send", path = "send")
public class AmqpApi {

    @Autowired
    private AmqpService amqpService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void sendToConsumer(@RequestBody Message message){
        amqpService.sendToConsumer(message);
    }
}
