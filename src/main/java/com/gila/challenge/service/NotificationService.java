package com.gila.challenge.service;
import com.gila.challenge.dto.MessageDto;
import com.gila.challenge.entity.Notification;

import java.util.List;

public interface NotificationService {
    void notifyUsers(MessageDto message);

    List<Notification> getLogs();
}