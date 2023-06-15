package com.gila.challenge.service;

import com.gila.challenge.entity.Notification;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(Notification notification) {
        // Code for sending push notification
        System.out.println("Sending push notification to user " + notification.getUser().getId() + " with message: " + notification.getMessage());
    }
}
