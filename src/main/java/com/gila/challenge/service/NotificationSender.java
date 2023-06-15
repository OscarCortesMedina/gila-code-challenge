package com.gila.challenge.service;

import com.gila.challenge.entity.Notification;

public interface NotificationSender {
    void sendNotification(Notification notification);

}
