package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.User;
import net.javaguides.springboot.publisher.RabbitMqJsonProducer;
import net.javaguides.springboot.publisher.RabbitMqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final RabbitMqProducer rabbitMqProducer;
    private final RabbitMqJsonProducer rabbitMqJsonProducer;

    public MessageController(RabbitMqProducer rabbitMqProducer, RabbitMqJsonProducer rabbitMqJsonProducer1) {
        this.rabbitMqProducer = rabbitMqProducer;
        this.rabbitMqJsonProducer = rabbitMqJsonProducer1;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {

        rabbitMqProducer.sendMessage(message);
        return ResponseEntity.ok("Message Sent To Rabbit MQ");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMqJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("json msg sent");
    }

}
