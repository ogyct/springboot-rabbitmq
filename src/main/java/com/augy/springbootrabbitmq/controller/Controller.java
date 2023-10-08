package com.augy.springbootrabbitmq.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.augy.springbootrabbitmq.messages.MessageConfig.MESSAGE_QUEUE;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {
    private final RabbitTemplate template;

    @PostMapping
    public void publishMessage(@RequestBody MyMessageDTO message) {
        template.convertAndSend(MESSAGE_QUEUE, message.getMessage());
    }
}
