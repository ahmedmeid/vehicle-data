package com.ahmedmeid.fleet.service;

import com.ahmedmeid.fleet.dto.Notification;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    private final Map<String, Consumer<Notification>> listeners = new ConcurrentHashMap<>();

    public void subscribe(String subscription, Consumer<Notification> listener) {
        listeners.put(subscription, listener);
        LOGGER.info("New consumer added, total consumers: {}", listeners.size());
    }

    public void publish(Notification notification) {
        LOGGER.info("Processing notification: {}", notification);
        listeners.get(notification.getSubscriptionId()).accept(notification);
    }
}
