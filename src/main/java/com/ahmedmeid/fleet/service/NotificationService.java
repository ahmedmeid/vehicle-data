package com.ahmedmeid.fleet.service;

import com.ahmedmeid.fleet.dto.Notification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    private final List<Consumer<Notification>> listeners = new CopyOnWriteArrayList<>();

    public void subscribe(Consumer<Notification> listener) {
        listeners.add(listener);
        LOGGER.info("New consumer added, total consumers: {}", listeners.size());
    }

    public void publish(Notification notification) {
        LOGGER.info("Processing notification: {}", notification);
        listeners.forEach(listener -> listener.accept(notification));
    }
}
