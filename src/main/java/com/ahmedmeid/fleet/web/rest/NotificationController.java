package com.ahmedmeid.fleet.web.rest;

import com.ahmedmeid.fleet.dto.Notification;
import com.ahmedmeid.fleet.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class NotificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/notification")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<Void>> sendNotification(@RequestBody Notification notification) {
        LOGGER.info("Received '{}'", notification);
        notificationService.publish(notification);
        return Mono.just(ResponseEntity.noContent().build());
    }

    @GetMapping(path = "/notification", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Object>> getNotifications() {
        return Flux
            .create(sink -> notificationService.subscribe(sink::next))
            .map(notification -> ServerSentEvent.builder().data(notification).event("notification").build());
    }
}
