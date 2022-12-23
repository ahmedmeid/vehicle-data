package com.ahmedmeid.fleet.web.rest;

import com.ahmedmeid.fleet.service.FiwareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class FiwareIoTController {

    private final FiwareService fiwareService;

    public FiwareIoTController(FiwareService fiwareService) {
        this.fiwareService = fiwareService;
    }

    @PostMapping("/servicegroup")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<Void>> createServiceGroup(@RequestParam(name = "apiKey") String apiKey) {
        fiwareService.provisionServiceGroup(apiKey);
        return Mono.just(ResponseEntity.noContent().build());
    }
}
