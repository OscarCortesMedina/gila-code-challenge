package com.gila.challenge.service;
import com.gila.challenge.dto.MessageDto;
import com.gila.challenge.entity.Notification;
import com.gila.challenge.entity.User;
import com.gila.challenge.enums.Channel;
import com.gila.challenge.factory.NotificationSenderFactory;
import com.gila.challenge.repository.NotificationRepository;
import com.gila.challenge.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationServiceImp implements NotificationService{

    private UserRepository userRepository;

    private NotificationRepository notificationRepository;

    public NotificationServiceImp(UserRepository userRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    public void notifyUsers(MessageDto message) {

        List<User> users = userRepository.findBySubscribedCategories(message.getCategory());
        for (User user : users) {
                for (Channel channel : user.getChannels()) {
                    if(channel!=null){

                        User userNotification = userRepository.findById(user.getId()).orElseThrow(
                                () -> new IllegalArgumentException("No user found with id: " + user.getId())
                        );
                        Notification notification = new Notification();
                        notification.setUser(userNotification);
                        notification.setMessage(message.getContent());
                        notification.setChannel(channel);
                        notification.setCategory(message.getCategory());
                        notification.setTime(LocalDate.now());
                        NotificationSender sender = NotificationSenderFactory.getNotificationSender(channel);

                        sender.sendNotification(notification);

                        logNotification(notification);

                    }


                }
        }
    }

    @Override
    public List<Notification> getLogs() {
        return notificationRepository.findAll();
    }

    @Transactional
    public void logNotification(Notification notification) {
        System.out.println("Sending " + notification.getChannel() + " notification to " + notification.getUser().getName() + " with message: " + notification.getMessage());
        notificationRepository.save(notification);
    }

}