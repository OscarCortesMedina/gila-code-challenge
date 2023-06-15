package com.gila.challenge.controller;
import com.gila.challenge.dto.MessageDto;
import com.gila.challenge.entity.Notification;
import com.gila.challenge.enums.Category;
import com.gila.challenge.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {


    private NotificationService notificationService;

    MessageController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendNotification")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMessage(@RequestParam Category category, @RequestParam String message) {
        if (message.isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be empty.");
        }

        MessageDto msn = new MessageDto();
        msn.setCategory(category);
        msn.setContent(message);

        notificationService.notifyUsers(msn);
    }

    @GetMapping("/logs")
    public List<Notification> getLogs() {
        return notificationService.getLogs();
    }


}
