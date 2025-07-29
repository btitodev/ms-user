package com.ms.user.produces;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms.user.dtos.EmailDTO;
import com.ms.user.models.UserModel;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        var emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setSubject("Welcome to our service");
        emailDTO.setText("Hello " + userModel.getName() + ",\n\nWelcome to our service!");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
