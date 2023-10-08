package com.augy.springbootrabbitmq.messages;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MessageConfig {

    public static final String MESSAGE_QUEUE = "MESSAGE_QUEUE";

    @Bean
    Queue messageQueue() {
        return new Queue(MESSAGE_QUEUE, false);
    }

    @RabbitListener(queues = MESSAGE_QUEUE)
    void listen(String in) {
        log.info("incoming: {}", in);
    }

}
