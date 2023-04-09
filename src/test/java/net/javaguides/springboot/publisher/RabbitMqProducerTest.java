package net.javaguides.springboot.publisher;

import net.javaguides.springboot.dto.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RabbitMqProducerTest {

    @InjectMocks
    RabbitMqProducer rabbitMqJsonProducer;

    @Mock
    RabbitTemplate rabbitTemplate;

    @Test
    void test()
    {
        assertDoesNotThrow(()->rabbitMqJsonProducer.sendMessage(new User().toString()));
    }

}
