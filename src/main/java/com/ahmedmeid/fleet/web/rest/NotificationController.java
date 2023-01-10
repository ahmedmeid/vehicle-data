package com.ahmedmeid.fleet.web.rest;

import com.ahmedmeid.fleet.dto.Notification;
import com.ahmedmeid.fleet.service.FiwareService;
import com.ahmedmeid.fleet.service.NotificationService;
import com.ahmedmeid.fleet.service.dto.subscription.Subscription;
import java.net.URISyntaxException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class NotificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);

    private final NotificationService notificationService;

    private final FiwareService fiwareService;

    public NotificationController(NotificationService notificationService, FiwareService fiwareService) {
        this.notificationService = notificationService;
        this.fiwareService = fiwareService;
    }

    @PostMapping("/subscribe")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<Subscription>> subscribe(@RequestParam(name = "deviceId") String deviceId) throws URISyntaxException {
        var location = fiwareService.subscribeIoTDeviceChanges(deviceId);
        Subscription subscription = Subscription.builder().subscriptionId(location).build();
        return Mono.just(ResponseEntity.of(Optional.of(subscription)));
    }

    @PostMapping("/notification")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<Void>> sendNotification(@RequestBody Notification notification) {
        LOGGER.info("Received '{}'", notification);
        notificationService.publish(notification);
        return Mono.just(ResponseEntity.noContent().build());
    }

    @GetMapping(path = "/notification", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Object>> getNotifications(@RequestParam(name = "sub") String subscriptionId) {
        return Flux
            .create(sink -> notificationService.subscribe(subscriptionId, sink::next))
            .map(notification -> ServerSentEvent.builder().data(notification).event("notification").build());
    }
}
