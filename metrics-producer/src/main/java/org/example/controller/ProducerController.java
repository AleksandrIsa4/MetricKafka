package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.service.ProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/metrics")
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping
    @Operation(summary = "Команда на отправку метрик приложение на сервер consumer-service через kafka")
    public void saveMetrics() {
        producerService.sendMetrics();
    }
}
