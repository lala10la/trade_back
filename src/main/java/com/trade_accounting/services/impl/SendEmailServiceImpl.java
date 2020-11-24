package com.trade_accounting.services.impl;

import com.trade_accounting.services.interfaces.SendEmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    private JavaMailSender javaMailSender = new JavaMailSenderImpl();

    @Override
    public void sendEmail(String to, String body, String topic) {
        System.out.println("sending email");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("trade_jm@mail.ru");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(topic);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
        System.out.println("sent email...");
    }
}
