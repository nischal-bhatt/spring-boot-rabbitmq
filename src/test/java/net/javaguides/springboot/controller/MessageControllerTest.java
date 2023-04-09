package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.User;
import net.javaguides.springboot.publisher.RabbitMqJsonProducer;
import net.javaguides.springboot.publisher.RabbitMqProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

    @InjectMocks
    MessageController messageController;

    @Mock
    RabbitMqJsonProducer rabbitMqJsonProducer;
    @Mock
    RabbitMqProducer rabbitMqProducer;

    @Test
    void test()
    {
        ResponseEntity<String> x = null;
        x = messageController.sendMessage("hi");
        assertEquals(x.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void test2()
    {
        ResponseEntity<String> x = null;
        x = messageController.sendJsonMessage(new User());
        assertEquals(x.getStatusCode(), HttpStatus.OK);
    }

}
