package com.augy.springbootrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;

import static com.augy.springbootrabbitmq.messages.MessageConfig.MESSAGE_QUEUE;

@SpringBootApplication
@Slf4j
public class SpringbootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        return args -> Flux.just(Instant.now().toString())
                .doOnNext(stringSignal -> {
                    log.info("emited {}", stringSignal);
                    template.convertAndSend(MESSAGE_QUEUE, stringSignal);

                })
                .onBackpressureBuffer()
                .delayElements(Duration.ofMillis(1000))
                .repeat()
                .subscribe();
    }
}
