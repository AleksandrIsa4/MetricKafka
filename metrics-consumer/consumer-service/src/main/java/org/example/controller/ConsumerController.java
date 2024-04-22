package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.dto.MetricsResponse;
import org.example.entity.Metrics;
import org.example.mapper.MetricsMapper;
import org.example.service.ConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/metrics")
public class ConsumerController {

    private final MetricsMapper metricsMapper;

    private final ConsumerService consumerService;

    @Operation(summary = "Получить все имеющиеся метрики")
    @GetMapping
    public List<MetricsResponse> findAllMetrics() {
        List<Metrics> metrics = consumerService.findAll();
        return metricsMapper.toMetricsResponseList(metrics);
    }

    @Operation(summary = "Получить метрики по её id")
    @GetMapping(value = "/{id}")
    public MetricsResponse findId(@PathVariable Long id) {
        Metrics metrics = consumerService.findId(id);
        return metricsMapper.toMetricsResponse(metrics);
    }
}
