package org.example.mapper;

import org.example.dto.MetricsResponse;
import org.example.entity.Metrics;
import org.example.model.MetricsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MetricsMapper {

    Metrics toMetrics(MetricsDto metricsDto);

    MetricsResponse toMetricsResponse(Metrics metrics);

    List<MetricsResponse> toMetricsResponseList(List<Metrics> metrics);
}
