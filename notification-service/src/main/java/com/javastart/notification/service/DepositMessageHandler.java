package com.javastart.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javastart.notification.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// этот класс будет отвечать за обработку смс, приходящих из RabbitMQ
@Service
public class DepositMessageHandler {
    // поле, которое умеет отправлять mail смс(настроили его в MailConfig)
    private final JavaMailSender javaMailSender;
    @Autowired
    public DepositMessageHandler(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    //эта аннотация работает как proxy так что с ней нужно быть аккуратным
    // нужно принимать очередь
    @RabbitListener(queues = RabbitMQConfig.QUEUE_DEPOSIT)
    public void receive(Message message) throws JsonProcessingException {
        System.out.println(message);
        // смс приходит в байтовом формате, поэтмоу нужно сделать некоторые действия по его обработке
        byte[] body = message.getBody();
        // байты можем преобразолвать в строку следующим путем
        String jsonBody = new String(body);
        //создадим объект object mapper, ведь удобнее работать в JSON format
        ObjectMapper objectMapper = new ObjectMapper();
        // создадим объект DepositResponseDTO
        DepositResponseDTO depositResponseDTO = objectMapper.readValue(jsonBody, DepositResponseDTO.class);
        System.out.println(depositResponseDTO);

        // ПОДГОТОВКА И ОТПРАВКА EMAIL

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(depositResponseDTO.getMail());
        //может работать, может нет (пока у нас нет своего SMTP сервера)
        mailMessage.setFrom("loricat@xyz.com");
        mailMessage.setSubject("Deposit");
        mailMessage.setText("Make deposit, sum: "+depositResponseDTO.getAmount());

        try {
            javaMailSender.send(mailMessage);
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }
}
