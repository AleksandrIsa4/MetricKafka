package org.example.repository;

import org.example.entity.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricsRepository extends JpaRepository<Metrics, Long> {

}
