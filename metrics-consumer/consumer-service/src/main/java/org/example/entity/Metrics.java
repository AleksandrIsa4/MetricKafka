package org.example.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Builder
public class Metrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Schema(description = "Имя потока в момент записи")
    String nameThread;

    @Schema(description = "Всего запущенных потоков в приложении")
    double threadsLive;

    @Schema(description = "Максимум памяти в байтах")
    double maxDataSize;

    @Schema(description = "Свободной памяти в байтах")
    long freeMemory;

    @Schema(description = "Доступные процессы")
    double availableProcessors;

    @Schema(description = "Время снятия метрики")
    LocalDateTime timestamp;
}
