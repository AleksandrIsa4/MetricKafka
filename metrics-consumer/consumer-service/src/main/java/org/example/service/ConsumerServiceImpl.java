package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Metrics;
import org.example.exceptions.DataNotFoundException;
import org.example.repository.MetricsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final MetricsRepository metricsRepository;

    public List<Metrics> findAll() {
        return metricsRepository.findAll();
    }

    public Metrics findId(Long id) {
        return metricsRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Нет записи с id=" + id));
    }
}
