package com.gila.challenge.service;

import com.gila.challenge.entity.Notification;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(Notification notification) {
        // Code for sending email
        System.out.println("Sending email to " + notification.getUser().getEmail() + " with message: " + notification.getMessage());
    }
}
