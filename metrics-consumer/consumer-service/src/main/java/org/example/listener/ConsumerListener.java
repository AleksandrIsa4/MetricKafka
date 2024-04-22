package org.example.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Metrics;
import org.example.mapper.MetricsMapper;
import org.example.model.MetricsDto;
import org.example.repository.MetricsRepository;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerListener {

    private final MetricsMapper metricsMapper;

    private final MetricsRepository metricsRepository;

    @KafkaListener(id = "1", topics = "metrics-topic")
    @RetryableTopic(attempts = "4", backoff = @Backoff(delay = 2000, maxDelay = 10000, multiplier = 2))
    public void listenMetric(MetricsDto metricsDto) {
        Metrics metrics = metricsMapper.toMetrics(metricsDto);
        metrics = metricsRepository.save(metrics);
        log.info("ConsumerListener listenMetric metrics: {}", metrics);
    }

    @DltHandler
    public void listenDlt(Object in, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset) {
        log.info("Ошибка при передачи сообщения: {}, topic: {}, offset: {}", in, topic, offset);
    }
}
