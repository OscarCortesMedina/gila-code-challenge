package com.gila.challenge.factory;

import com.gila.challenge.enums.Channel;
import com.gila.challenge.service.EmailNotificationSender;
import com.gila.challenge.service.NotificationSender;
import com.gila.challenge.service.PushNotificationSender;
import com.gila.challenge.service.SmsNotificationSender;

public class NotificationSenderFactory {
    public static NotificationSender getNotificationSender(Channel channel) {
        switch (channel) {
            case EMAIL:
                return new EmailNotificationSender();
            case SMS:
                return new SmsNotificationSender();
            case PUSH_NOTIFICATION:
                return new PushNotificationSender();
            default:
                throw new IllegalArgumentException("Invalid channel type: " + channel);
        }
    }
}
