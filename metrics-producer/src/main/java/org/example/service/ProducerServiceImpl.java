package org.example.service;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.MetricsDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<Object, Object> template;

    private final MeterRegistry meterRegistry;

    @Override
    public void sendMetrics() {
        MetricsDto metricsDto = MetricsDto.builder()
                .timestamp(LocalDateTime.now())
                .threadsLive(meterRegistry.get("jvm.threads.live").gauge().value())
                .availableProcessors(meterRegistry.get("system.cpu.count").gauge().value())
                .freeMemory(Runtime.getRuntime().freeMemory())
                .nameThread(Thread.currentThread().getName())
                .maxDataSize(meterRegistry.get("jvm.gc.max.data.size").gauge().value())
                .build();
        log.info("Metrics: {}", metricsDto);
        template.send("metrics-topic", metricsDto);
    }
}
