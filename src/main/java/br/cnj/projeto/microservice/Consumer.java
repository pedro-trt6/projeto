package br.cnj.projeto.microservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.cnj.projeto.config.QueueConfig;

@Component
public class Consumer {

    private static final Logger logger = LogManager.getLogger(Consumer.class);

    @RabbitListener(queues = {QueueConfig.NOME_FILA})
    public void receive(@Payload String fileBody) {
        logger.info("Recebi essa mensagem: " + fileBody);
    }

}
