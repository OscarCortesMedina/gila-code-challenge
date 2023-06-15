package com.gila.challenge.service;

import com.gila.challenge.entity.Notification;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(Notification notification) {
        // Code for sending SMS
        System.out.println("Sending SMS to " + notification.getUser().getPhone() + " with message: " + notification.getMessage());
    }
}